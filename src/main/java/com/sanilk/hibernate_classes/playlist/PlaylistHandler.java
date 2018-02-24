package com.sanilk.hibernate_classes.playlist;

import com.sanilk.hibernate_classes.comment.Comment;
import com.sanilk.hibernate_classes.genre.Genre;
import com.sanilk.hibernate_classes.song.Song;
import com.sanilk.hibernate_classes.song.SongHandler;
import com.sanilk.hibernate_classes.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;
import java.util.Random;

public class PlaylistHandler {
    SessionFactory sessionFactory;

    public PlaylistHandler(){
        Configuration configuration=new Configuration()
                .configure()
                .addAnnotatedClass(Song.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Playlist.class);
        ServiceRegistry standardServiceRegistry= new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory=configuration.buildSessionFactory(standardServiceRegistry);
    }

    public Playlist getRandomPlaylist(){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from com.sanilk.hibernate_classes.playlist.Playlist");
        List<Playlist> playlists=query.getResultList();

        if(playlists.size()==0){
            return null;
        }

        Random random=new Random();
        int r=random.nextInt(playlists.size());
        Playlist finalPlaylistSelected=playlists.get(r);

        session.getTransaction().commit();
        session.close();

        return finalPlaylistSelected;
    }

    public void savePlaylist(Playlist p){

        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();

        session.save(p);

        t.commit();
    }

    public Playlist getPlaylist(String name){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from com.sanilk.hibernate_classes.playlist.Playlist where name=:n");
        query.setParameter("n", name);
        List<Playlist> playlists=query.getResultList();

        for(Playlist p:playlists){
            System.out.println(p);
        }

        session.getTransaction().commit();
        session.close();

        if(playlists.size()>0){
            return playlists.get(0);
        }
        return null;
    }

    public Playlist getPlaylist(int playlistId){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from com.sanilk.hibernate_classes.playlist.Playlist where playlistId=:p");
        query.setParameter("p", playlistId);
        List<Playlist> playlists=query.getResultList();

        for(Playlist p:playlists){
            System.out.println(p);
        }

        session.getTransaction().commit();
        session.close();

        if(playlists.size()>0){
            return playlists.get(0);
        }
        return null;
    }

}
