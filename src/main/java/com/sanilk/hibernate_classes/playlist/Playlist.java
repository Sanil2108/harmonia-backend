package com.sanilk.hibernate_classes.playlist;

import com.sanilk.hibernate_classes.comment.Comment;
import com.sanilk.hibernate_classes.song.Song;
import com.sanilk.hibernate_classes.user.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by root on 5/2/18.
 */
@Entity
@Table(name="PLAYLIST")
public class Playlist {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistId;
    private String genres;
    private int points;

    public Playlist(){}

    @ManyToOne()
    @JoinColumn(name = "username", nullable = true)
    private User creator;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "PLAYLIST_SONG",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "songId")
    )
    public Set<Song> songSet;

    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
    public Set<Comment> comments;

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", playlistId=" + playlistId +
                ", genre='" + genres + '\'' +
                ", points=" + points +
                '}';
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Song> getSongSet() {
        return songSet;
    }

    public void setSongSet(Set<Song> songSet) {
        this.songSet = songSet;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Playlist(String name, String genres, int points, Set<Song> songSet) {
        this.name = name;
        this.genres = genres;
        this.points = points;
        this.songSet = songSet;
    }

    public Playlist(String name, String genres, int points) {
        this.name = name;
        this.genres = genres;
        this.points = points;
    }
}
