package com.sanilk.hibernate_classes.comment;

import com.sanilk.hibernate_classes.playlist.Playlist;
import com.sanilk.hibernate_classes.user.User;

import javax.persistence.*;

/**
 * Created by root on 20/2/18.
 */

@Entity
@Table(name="COMMENT")
public class Comment {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    private String text;
    private String date;

    @ManyToOne
    private Playlist playlist;

    @ManyToOne
    private User song;

    public Comment(String text, String date, Playlist playlist, User song) {
        this.text = text;
        this.date = date;
        this.playlist = playlist;
        this.song = song;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", playlist=" + playlist +
                ", song=" + song +
                '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public User getSong() {
        return song;
    }

    public void setSong(User song) {
        this.song = song;
    }
}
