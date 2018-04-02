package com.sanilk.hibernate_classes.notification;

import com.sanilk.hibernate_classes.song.Song;
import com.sanilk.hibernate_classes.song.SongHandler;
import com.sanilk.hibernate_classes.user.User;
import com.sanilk.hibernate_classes.user.UserHandler;

import javax.persistence.*;

/**
 * Created by root on 28/2/18.
 */
@Entity
@Table(name = "NOTIFICATION_TABLE")
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int notificationId;

    @OneToOne
    private User user;

    @Column
    private String date;

    @Column
    private String text;

    public Notification(){}

    public Notification(String username, String date, String text) {
        UserHandler userHandler=new UserHandler();
        this.user=userHandler.getUser(username);
        this.date = date;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
