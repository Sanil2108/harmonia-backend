package com.sanilk.requests;

/**
 * Created by root on 20/2/18.
 */
public class GetCommentsByPlaylistIdRequest extends MyRequest {
    public static final String REQUEST_TYPE="GET_COMMENTS_BY_ID";
    public static final String PLAYLIST_ID_KEY="playlist_id";

    private String playlistId;

    public GetCommentsByPlaylistIdRequest(String playlistId) {
        this.playlistId = playlistId;

        this.requestType=REQUEST_TYPE;
    }

    @Override
    public String toString() {
        return "GetCommentsByPlaylistIdRequest{" +
                "requestType='" + requestType + '\'' +
                ", playlistId='" + playlistId + '\'' +
                '}';
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }
}
