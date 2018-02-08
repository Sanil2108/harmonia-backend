package com.sanilk.hibernate_classes.song;

import com.sanilk.hibernate_classes.playlist.Playlist;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="SONG")
public class Song {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songId;
    private String artist;

    @ManyToMany(mappedBy = "songSet")
    public Set<Playlist> playlists;

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", songId=" + songId +
                ", artist='" + artist + '\'' +
                '}';
    }

    public Song(int songId, String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songId=songId;
    }

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
