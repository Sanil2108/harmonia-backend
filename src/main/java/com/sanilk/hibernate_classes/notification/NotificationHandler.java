package com.sanilk.hibernate_classes.notification;

import com.sanilk.hibernate_classes.comment.Comment;
import com.sanilk.hibernate_classes.genre.Genre;
import com.sanilk.hibernate_classes.playlist.Playlist;
import com.sanilk.hibernate_classes.song.Song;
import com.sanilk.hibernate_classes.user.User;
import com.sanilk.hibernate_classes.user.UserHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;


/**
 * Created by root on 28/2/18.
 */
public class NotificationHandler {

    SessionFactory sessionFactory;
    public NotificationHandler(){
        Configuration configuration=new Configuration()
                .configure()
                .addAnnotatedClass(Notification.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Playlist.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Song.class)
                .addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry=configuration
                .getStandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public List<Notification> getNotifications(String username){
        List<Notification> notifications;

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        UserHandler userHandler=new UserHandler();
        User u=userHandler.getUser(username);

        session.persist(u);

        Query query=session.createQuery("from com.sanilk.hibernate_classes.notification.Notification where user=:u");
        query.setParameter("u", u);
        notifications=query.getResultList();

        session.getTransaction().commit();
        session.close();

        return notifications;
    }

    public void newPlaylistCreatedNotification(Playlist playlist){
//        Notification notification=new Notification(
//                playlist,
//                new Date().toString(),
//                "You just created a new playlist. Click here to share with all your friends"
//        );
    }

    public void newCommentNotification(Comment comment){

    }

}
