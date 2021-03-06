package com.sanilk.hibernate_classes.user;

import com.sanilk.hibernate_classes.comment.Comment;
import com.sanilk.hibernate_classes.playlist.Playlist;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by root on 28/1/18.
 */
@Entity
@Table(name="USER")
public class User {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=1;
    private String password;
    private String email;

    @OneToMany(mappedBy = "creator")
    private Set<Playlist> playlists;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Comment> commentSet;

    public User(){}

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, int id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
