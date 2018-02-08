package com.sanilk.requests;

import java.util.Arrays;

public class CreatePlaylistRequest extends MyRequest{

    public static final String REQUEST_TYPE="CREATE_PLAYLIST";
    public static final String USER_NAME_KEY="user_name";
    public static final String SONGS_COUNT="songs_count";
    public static final String SONGS_KEY="songs";

    private String userName;
    private Song[] songs;
    private int songsCount;

    public CreatePlaylistRequest(String userName, Song[] songs, int songsCount) {
        this.userName = userName;
        this.songs = songs;
        this.songsCount = songsCount;
    }

    @Override
    public String toString() {
        return "CreatePlaylistRequest{" +
                "userName='" + userName + '\'' +
                ", songs=" + Arrays.toString(songs) +
                ", songsCount=" + songsCount +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public int getSongsCount() {
        return songsCount;
    }

    public void setSongsCount(int songsCount) {
        this.songsCount = songsCount;
    }

    public static class Song{
        public static final String LINK_KEY="link";
        public static final String NAME_KEY="name";
        public static final String GENRES_KEY="genres";
        public static final String ARTIST_KEY="artist";
        public static final String GENRES_COUNT_KEY="genres_count";

        private String link;
        private String name;
        private Genre[] genres;
        private String artist;
        private int genresCount;

        @Override
        public String toString() {
            return "Song{" +
                    "link='" + link + '\'' +
                    ", name='" + name + '\'' +
                    ", genres=" + Arrays.toString(genres) +
                    ", artist='" + artist + '\'' +
                    ", genresCount=" + genresCount +
                    '}';
        }

        public Song(String link, String name, Genre[] genres, String artist, int genresCount) {
            this.link = link;
            this.name = name;
            this.genres = genres;
            this.artist = artist;
            this.genresCount = genresCount;
        }

        public int getGenresCount() {
            return genresCount;
        }

        public void setGenresCount(int genresCount) {
            this.genresCount = genresCount;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Genre[] getGenres() {
            return genres;
        }

        public void setGenres(Genre[] genres) {
            this.genres = genres;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
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
}