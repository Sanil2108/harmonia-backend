package com.sanilk.requests;

/**
 * Created by root on 3/2/18.
 */
public class AuthenticateRequest extends MyRequest{
    public static final String REQUEST_TYPE="AUTHENTICATE";
    public static final String USER_NAME_KEY="user_name";
    public static final String PASSWORD_KEY="password";

    private String userName;
    private String password;

    public AuthenticateRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;

        this.requestType=REQUEST_TYPE;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
