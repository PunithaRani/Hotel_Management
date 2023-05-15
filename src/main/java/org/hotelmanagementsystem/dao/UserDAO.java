package org.hotelmanagementsystem.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hotelmanagementsystem.dto.UserInfoDTO;
import org.hotelmanagementsystem.exception.RoomException;
import org.hotelmanagementsystem.model.RoomDetails;
import org.hotelmanagementsystem.model.UserInfo;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Repository("userDAO")
public class UserDAO {

    public String saveUser(UserInfo userInfo) {
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(userInfo);
            transaction.commit();
        } catch(Exception e) {
            return null;
        } finally {
            session.close();
        }
        return "Details are stored successfully";
    }

    public List<UserInfo> getAllUserInfo() {
        List<UserInfo> userInfo;
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            userInfo = session.createQuery("select a from UserInfo a", UserInfo.class).list();
            transaction.commit();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
        return userInfo;
    }

    public UserInfo getUserByEmail(String email) {
        UserInfo userInfo;
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            userInfo = session.get(UserInfo.class, email);
            transaction.commit();
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
        return userInfo;
    }
   

    public String checkUser(String email, String keyword) {
        List<UserInfo> userInfo;
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            userInfo = session.createQuery("select a from UserInfo a where email = '" + email + "' and keyword = '" + keyword + "'").list();
            transaction.commit();
        } catch(Exception e) {
            return null;
        } finally {
            session.close();
        }
        if (userInfo.isEmpty()) {
            return null;
        }
        return "valid";
    }

    public String setPassword(String email, String password) {
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            UserInfo userInfo = session.get(UserInfo.class, email);
            userInfo.setPassword(password);
            session.update(userInfo);
            transaction.commit();
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
        return "valid";
    }
    /////////////
    public String updateUserDetails(UserInfoDTO userDetails,String email) {
     //   logger.info("Entering into a update room DAO");
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
           // String hqlUpdate = "update UserInfo user set user.firstName = :"+userDetails.getFirstName()+",user.lastName=:"+userDetails.getLastName()+" where user.email = :"+email;
            String hqlUpdate = "update UserInfo user set user.firstName = :fname,user.lastName=:lname,user.email=:email1,user.mobileNumber=:mobile where user.email = :email";
           
           // session.createQuery(hqlUpdate).executeUpdate();
            
   session.createQuery( hqlUpdate ).setParameter( "fname", userDetails.getFirstName() )
                 .setParameter( "lname", userDetails.getLastName() )
                 .setParameter( "email1",userDetails.getEmail() )
                 .setParameter( "mobile",userDetails.getMobileNumber() )
                 .setParameter( "email",email )
                 .executeUpdate();
            
         System.out.print(userDetails.getFirstName()+" "+userDetails.getLastName());
           // session.update(userDetails);
           // logger.info("Details are successfully updated");
            transaction.commit();
        } catch(Exception e) {
           // logger.error("Room number already exist");
            return new RoomException("Room No : "  + " does not exists").getErrorMessage();
        } finally {
            session.close();
        }
        //logger.info(REDIRECT_MESSAGE);
        return "valid";
    //    return VALID_MESSAGE;
    }
    

    public List<String> getAllEmail() {
        List<String> userInfo;
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            userInfo = session.createQuery("select email from UserInfo a").list();
            System.out.print(userInfo);
            transaction.commit();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
        return userInfo;
    }
}
