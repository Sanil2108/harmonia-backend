package com.sanilk.requests;

/**
 * Created by root on 21/2/18.
 */
public class GetCommentsByUserRequest extends MyRequest {
    public static final String REQUEST_TYPE="GET_COMMENTS_BY_USER";
    public static final String USERNAME_KEY="username";

    private String username;

    public GetCommentsByUserRequest(String username){
        this.username=username;

        this.requestType=REQUEST_TYPE;
    }

    @Override
    public String toString() {
        return "GetCommentsByUserRequest{" +
                "requestType='" + requestType + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}