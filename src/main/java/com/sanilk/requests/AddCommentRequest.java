package com.sanilk.requests;

/**
 * Created by root on 20/2/18.
 */
public class AddCommentRequest extends MyRequest {
    public static final String REQUEST_TYPE="ADD_COMMENT_REQUEST";
    public static final String USERNAME_KEY="username";
    public static final String PLAYLIST_ID_KEY="playlist_id";
    public static final String TEXT_KEY="text";

    public String username;
    public int playlistId;
    public String text;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AddCommentRequest{" +
                "requestType='" + requestType + '\'' +
                ", username='" + username + '\'' +
                ", playlistId='" + playlistId + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public AddCommentRequest(String username, int playlistId, String text) {
        this.username = username;
        this.playlistId = playlistId;
        this.text = text;

        this.requestType=REQUEST_TYPE;
    }
}
