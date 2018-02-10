package com.sanilk.hibernate_classes.song;

import com.sanilk.hibernate_classes.genre.Genre;
import com.sanilk.hibernate_classes.playlist.Playlist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class SongHandler {
    SessionFactory sessionFactory;

    public SongHandler(){
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Song.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Playlist.class)
                .configure();
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public void saveSong(Song s){
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(s);

        for(Genre g:s.genres){
            session.save(g);
        }

        tx.commit();
        session.close();
    }

    public Song getSong(int songId){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from com.sanilk.hibernate_classes.song.Song where songId=:s");
        query.setParameter("s", songId);
        List<Song> l=query.getResultList();

        session.getTransaction().commit();
        session.close();

        if(l.size()>0){
            return l.get(0);
        }else{
            return null;
        }
    }
}
