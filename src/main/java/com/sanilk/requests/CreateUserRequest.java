package com.sanilk.requests;

/**
 * Created by root on 3/2/18.
 */
public class CreateUserRequest extends MyRequest {

    public static final String REQUEST_TYPE="CREATE_USER";
    public static final String USER_NAME_KEY="user_name";
    public static final String PASSWORD_KEY="password";
    public static final String EMAIL_KEY="email";
    public static final String FIRST_NAME_KEY="first_name";
    public static final String LAST_NAME_KEY="last_name";

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public CreateUserRequest(String userName, String password, String email, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        this.requestType=REQUEST_TYPE;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
