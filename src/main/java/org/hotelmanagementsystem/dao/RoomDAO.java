package org.hotelmanagementsystem.dao;


import org.apache.log4j.Logger;
import org.hotelmanagementsystem.exception.DbConnectionLostException;
import org.hotelmanagementsystem.exception.RoomException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hotelmanagementsystem.model.RoomDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("RoomDAO")
public class RoomDAO {

    private static final String REDIRECT_MESSAGE = "Returning to room service";
    private static final String VALID_MESSAGE = "Valid";
    private static Logger logger = Logger.getLogger(RoomDAO.class);

    public String storeRoomDetails(RoomDetails roomDetails){
        logger.info("Entering into a store room DAO");
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(roomDetails);
            transaction.commit();
        } catch(Exception e) {
            try {
                throw new RoomException("Room Number already Exists");
            } catch(RoomException exp) {
                logger.error("Details are failed to store");
                return exp.getErrorMessage();
            }
        } finally {
            session.close();
        }
        logger.info("Details are stored successfully");
        logger.info(REDIRECT_MESSAGE);
        return VALID_MESSAGE;
    }

    public List<RoomDetails> getAllRoomDetails(){
        logger.info("Entering into a get all room details DAO");
        List<RoomDetails> roomDetails;
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            roomDetails = session.createQuery("select rd from RoomDetails rd order by roomNumber ASC", RoomDetails.class).list();
            logger.info(roomDetails);
            transaction.commit();
        } catch(Exception e) {
            try {
                throw new DbConnectionLostException("Database connection is lost");
            } catch(DbConnectionLostException exp) {
                logger.error("Database connection is lost");
                return new ArrayList<>();
            }
        } finally {
            session.close();
        }
        logger.info(REDIRECT_MESSAGE);
        return roomDetails;
    }

    public String updateRoomDetails(RoomDetails roomDetails) {
        logger.info("Entering into a update room DAO");
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(roomDetails);
            logger.info("Details are successfully updated");
            transaction.commit();
        } catch(Exception e) {
            logger.error("Room number already exist");
            return new RoomException("Room No : " + roomDetails.getRoomNumber() + " does not exists").getErrorMessage();
        } finally {
            session.close();
        }
        logger.info(REDIRECT_MESSAGE);
        return VALID_MESSAGE;
    }

    public RoomDetails getRoomDetails(int roomNumber) {
        logger.info("Entering into a get room by number DAO");
        RoomDetails roomDetails;
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            roomDetails = session.get(RoomDetails.class, roomNumber);
            logger.info(roomDetails);
            transaction.commit();
        } catch(Exception e) {
            logger.error("Failed to get details");
            return null;
        } finally {
            session.close();
        }
        logger.info(REDIRECT_MESSAGE);
        return roomDetails;
    }

    public String deleteRoomDetails(int roomNumber) {
        logger.info("Entering into a delete room DAO");
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            RoomDetails roomDetails = session.get(RoomDetails.class, roomNumber);
            logger.info(roomDetails);
            session.delete(roomDetails);
            logger.info("Deleted successfully");
            transaction.commit();
            session.close();
        } catch(Exception e) {
            logger.error("Failed to delete");
            return null;
        } finally {
            session.close();
        }
        logger.info(REDIRECT_MESSAGE);
        return VALID_MESSAGE;
    }

    public List<RoomDetails> getRoomDetailsByRoomType(String roomType) {
        logger.info("Entering into a get room details by room type DAO");
        List<RoomDetails> roomDetails;
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            roomDetails = session.createQuery("select a from RoomDetails a where roomType = '" + roomType + "'", RoomDetails.class).list();
            logger.info(roomDetails);
            transaction.commit();
        } catch(Exception e) {
            logger.error("Failed to get the details");
            return new ArrayList<>();
        } finally {
            session.close();
        }
        logger.info(REDIRECT_MESSAGE);
        return roomDetails;
    }

    public String updateAvailability(int roomNumber) {
        logger.info("Entering into a update room availability DAO");
        Configuration con = new Configuration().configure().addAnnotatedClass(RoomDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            RoomDetails roomDetails = session.get(RoomDetails.class, roomNumber);
            roomDetails.setRoomAvailability(true);
            session.update(roomDetails);
            logger.info("Updated successfully");
            transaction.commit();
        } catch(Exception e) {
            logger.error("Failed to change");
            return null;
        } finally {
            session.close();
        }
        logger.info(REDIRECT_MESSAGE);
        return "valid";
    }

}
