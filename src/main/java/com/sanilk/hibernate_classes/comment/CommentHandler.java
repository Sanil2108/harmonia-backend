package com.sanilk.hibernate_classes.comment;

import com.sanilk.hibernate_classes.genre.Genre;
import com.sanilk.hibernate_classes.playlist.Playlist;
import com.sanilk.hibernate_classes.song.Song;
import com.sanilk.hibernate_classes.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;


/**
 * Created by root on 20/2/18.
 */
public class CommentHandler {
    SessionFactory sessionFactory;

    public CommentHandler(){
        Configuration configuration=new Configuration()
                .configure()
                .addAnnotatedClass(Playlist.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Song.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Comment.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public void newComment(Comment comment){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(comment);

        session.getTransaction().commit();
        session.close();
    }

    public List<Comment> getComments(String playlistId){
        Session session=sessionFactory.openSession();

        Query query=session
                .createQuery("from com.sanilk.hibernate_classes.comment.Comment where playlist=:p");
        query.setParameter("p", playlistId);
        List<Comment> comments=query.getResultList();

        return comments;
    }

}
