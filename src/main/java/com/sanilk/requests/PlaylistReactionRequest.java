package com.sanilk.requests;

/**
 * Created by root on 28/2/18.
 */
public class PlaylistReactionRequest extends MyRequest {
    public static final String REQUEST_TYPE="PLAYLIST_REACTION_TYPE";

    public static final String PLAYLIST_ID_KEY="playlist_id";
    public static final String REACTION_KEY="reaction";

    private String reaction;
    private int playlistId;

    public PlaylistReactionRequest(String reaction, int playlistId) {
        this.reaction = reaction;
        this.playlistId = playlistId;

        this.requestType=REQUEST_TYPE;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }
}
