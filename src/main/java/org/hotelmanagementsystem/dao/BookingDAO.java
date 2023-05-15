package org.hotelmanagementsystem.dao;

import org.hotelmanagementsystem.exception.DbConnectionLostException;
import org.hotelmanagementsystem.model.BookingDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hotelmanagementsystem.model.RoomDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("BookingDAO")
public class BookingDAO {

    public String saveBookingsDAO(BookingDetails bookingDetail)  {
        Configuration con = new Configuration().configure().addAnnotatedClass(BookingDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(bookingDetail);
            transaction.commit();
        } catch(Exception ex) {
            try {
                throw new DbConnectionLostException("Database connection is lost");
            } catch (DbConnectionLostException e) {
                return e.getErrorMessage();
            }
        } finally {
            session.close();
        }
        return "valid";
    }


    public List<BookingDetails> getBookingsDetails() {
        List<BookingDetails> bookingDetails;
        Configuration con = new Configuration().configure().addAnnotatedClass(BookingDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            bookingDetails = session.createQuery("select a from BookingDetails a", BookingDetails.class).list();
            transaction.commit();
        } catch(Exception e) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
        return bookingDetails;
    }
    public BookingDetails getLastBookingsDetails() {
        BookingDetails bookingDetails;
        Configuration con = new Configuration().configure().addAnnotatedClass(BookingDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            bookingDetails = session.createQuery("select a from BookingDetails a ORDER BY bookingId DESC",BookingDetails.class) .setMaxResults(1).uniqueResult();
          
            transaction.commit();
        } catch(Exception e) {
            return null;
        } finally {
            session.close();
        }
      
        return bookingDetails;
    }

    public List<BookingDetails> getBookingsDetailsByEmailId(String bookingName) {
        List<BookingDetails> bookingDetails;
        Configuration con = new Configuration().configure().addAnnotatedClass(BookingDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            bookingDetails = session.createQuery("select a from BookingDetails a where bookingName = '" + bookingName + "'", BookingDetails.class).list();
            transaction.commit();
        } catch(Exception e) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
        return bookingDetails;
    }

    public String changeAvailable(int roomNumber) {
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            RoomDetails roomDetails = session.get(RoomDetails.class, roomNumber);
            roomDetails.setRoomAvailability(false);
            session.update(roomDetails);
            transaction.commit();
        } catch(Exception e) {
            return null;
        } finally {
            session.close();
        }
        return "valid";
    }
}
