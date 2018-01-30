package com.sanilk;

import com.sanilk.hibernate_classes.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by root on 26/1/18.
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration=new Configuration().configure()
                .addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        User user=new User(name,0,password,email);
        session.save(user);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
