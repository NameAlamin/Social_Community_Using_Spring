package com.dao;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void store(User user){
        Session session = sessionFactory.getCurrentSession();
        try{
            session.save(user);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

//    public List<User> getAll(){
//        Query query = sessionFactory.getCurrentSession().createQuery("FROM User", User.class);
//        List<User> userList = query.list();
//
//        return userList;
//    }


    public List<User> getAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User", User.class);
        List<User> userList = query.list();

        return userList;
    }

}