package com.sanilk.requests;

/**
 * Created by root on 28/2/18.
 */
public class GetNotificationsRequest extends MyRequest {
    public static final String REQUEST_TYPE="GET_NOTIFICATIONS_REQUEST";

    public static final String USERNAME_KEY="username";

    private String username;

    public GetNotificationsRequest(String username) {
        this.username = username;

        this.requestType=REQUEST_TYPE;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
