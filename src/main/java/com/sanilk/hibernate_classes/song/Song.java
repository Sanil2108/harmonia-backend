package com.sanilk.hibernate_classes.song;

import com.sanilk.hibernate_classes.comment.Comment;
import com.sanilk.hibernate_classes.genre.Genre;
import com.sanilk.hibernate_classes.playlist.Playlist;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="SONG")
public class Song {
    private String name;
    @Id
    @Column(name="songId")
    private String songId;
    private String artist;

    @ManyToOne
    @JoinColumn(
            name="playlistId", nullable = true
    )
    public Playlist playlist;

    @OneToMany(mappedBy = "song", fetch = FetchType.EAGER)
    public Set<Genre> genres;

    @OneToMany(mappedBy = "song", fetch = FetchType.EAGER)
    public Set<Comment> comments;

    public Song(){}

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", songId='" + songId + '\'' +
                ", artist='" + artist + '\'' +
                ", playlist=" + playlist +
                ", genres=" + genres +
                '}';
    }

    public Song(String name, String songId, String artist, Playlist playlist, Set<Genre> genres) {
        this.name = name;
        this.songId = songId;
        this.artist = artist;
        this.playlist = playlist;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
