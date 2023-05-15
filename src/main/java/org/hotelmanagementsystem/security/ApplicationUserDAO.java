package org.hotelmanagementsystem.security;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hotelmanagementsystem.model.UserInfo;

import org.springframework.stereotype.Repository;


@Repository
public class ApplicationUserDAO implements IApplicationUserDAO {

    @Override
    public UserInfo getUser(String username) {
        UserInfo user;
        Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            user = session.get(UserInfo.class, username);
            transaction.commit();
        } catch(Exception e) {
            return null;
        } finally {
            session.close();
        }
        return user;
    }
}
