package com.sanilk.requests;

/**
 * Created by root on 20/2/18.
 */
public class GetCommentsByPlaylistIdRequest extends MyRequest {
    public static final String REQUEST_TYPE="GET_COMMENTS_BY_ID_REQUEST";
    public static final String PLAYLIST_ID_KEY="playlist_id";

    private int playlistId;

    public GetCommentsByPlaylistIdRequest(int playlistId) {
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

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }
}
