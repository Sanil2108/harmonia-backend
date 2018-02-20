package com.sanilk.hibernate_classes.comment;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by root on 20/2/18.
 */
public class CommentHandler {
    SessionFactory sessionFactory;

    public CommentHandler(){
        Configuration configuration=new Configuration()
                .configure()
                .addAnnotatedClass(Comment.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

}
