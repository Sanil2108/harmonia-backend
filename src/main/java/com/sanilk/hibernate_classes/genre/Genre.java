package com.sanilk.hibernate_classes.genre;

import com.sanilk.hibernate_classes.song.Song;

import javax.persistence.*;

/**
 * Created by root on 9/2/18.
 */
@Entity
@Table(name = "GENRE")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "songId", nullable = true
    )
    private Song song;

    public Genre(String name, Song song) {
        this.name = name;
        this.song = song;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", name='" + name + '\'' +
                ", song=" + song +
                '}';
    }

    public Genre(){}

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
