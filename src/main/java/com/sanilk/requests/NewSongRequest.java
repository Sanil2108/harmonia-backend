package com.sanilk.requests;

import java.util.Arrays;

/**
 * Created by root on 8/2/18.
 */
public class NewSongRequest extends MyRequest{
    public static final String REQUEST_TYPE="NEW_SONG";
    public static final String USER_NAME_KEY="user_name";
    public static final String ID_KEY="id";
    public static final String NAME_KEY="name";
    public static final String ARTIST_KEY="artist";
    public static final String GENRES_COUNT_KEY="genres_count";
    public static final String GENRES_KEY="genres";

    private String userName;
    private String id;
    private String name;
    private String artist;
    private Genre[] genres;

    public NewSongRequest(String userName, String id, String name, String artist, Genre[] genres) {
        this.userName = userName;
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genres = genres;

        this.requestType=REQUEST_TYPE;
    }

    @Override
    public String toString() {
        return "NewSongRequest{" +
                "userName='" + userName + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre=" + Arrays.toString(genres) +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }


    public static class Genre{
        public static final String NAME_KEY="name";

        private String name;

        @Override
        public String toString() {
            return "Genre{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Genre(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
