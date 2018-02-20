package com.sanilk.requests;

/**
 * Created by root on 17/2/18.
 */
public class GetRandomPlaylistRequest extends MyRequest {

    public static final String REQUEST_TYPE="GET_RANDOM_PLAYLIST_REQUEST";
    public static final String GENRES_COUNT_KEY="genres_count";
    public static final String GENRES_KEY="genres";

    private String[] genres;
    private int genresCount;

    public GetRandomPlaylistRequest(String[] genres, int genresCount) {
        this.genres = genres;
        this.genresCount=genresCount;

        this.requestType=REQUEST_TYPE;
    }

    public int getGenresCount() {
        return genresCount;
    }

    public void setGenresCount(int genresCount) {
        this.genresCount = genresCount;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }
}
