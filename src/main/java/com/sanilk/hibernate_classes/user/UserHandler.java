package com.sanilk.hibernate_classes.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;

public class UserHandler {
    AllUsers allUsers;
    SessionFactory sessionFactory;

    public UserHandler(){
        allUsers=AllUsers.getAllUsers();
        Configuration configuration=new Configuration()
                .configure()
                .addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public void saveUser(User user){
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();

        session.save(user);

        t.commit();
        session.close();
    }

    public User getUser(String username){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from com.sanilk.hibernate_classes.user.User where name=:name");
        query.setParameter("name", username);
        List<User> users=query.getResultList();

        for(User u:users){
            System.out.println(u);
        }

        session.getTransaction().commit();
        session.close();

        if(users.size()>0) {
            return users.get(0);
        }
        return null;
    }

    public User getUser(int id){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from com.sanilk.hibernate_classes.user.User where id=:id");
        query.setParameter("id", id);
        List<User> users=query.getResultList();

        for(User u:users){
            System.out.println(u);
        }

        session.getTransaction().commit();
        session.close();

        return users.get(0);
    }

    public void populateList(){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<User> users=session.createQuery("from com.sanilk.hibernate_classes.user.User").list();
        allUsers.users=users;
        session.close();
    }

}
