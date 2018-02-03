package com.sanilk;

import com.sanilk.requests.CreateUserRequest;
import com.sanilk.requests.MyRequest;
import org.json.JSONObject;

/**
 * Created by root on 3/2/18.
 */
public class JSONParser {

    public MyRequest parse(String text){
        JSONObject jsonObject=new JSONObject(text);
        String typeOfRequest=jsonObject.getString(MyRequest.REQUEST_TYPE_KEY);
        switch (typeOfRequest){
            case CreateUserRequest.REQUEST_TYPE:
                return parseCreateUserRequest(jsonObject);
            default:
                return null;
        }
    }

    private CreateUserRequest parseCreateUserRequest(JSONObject jsonObject){
        String userName=jsonObject.getString(CreateUserRequest.USER_NAME_KEY);
        String firstName=jsonObject.getString(CreateUserRequest.FIRST_NAME_KEY);
        String lastName=jsonObject.getString(CreateUserRequest.LAST_NAME_KEY);
        String password=jsonObject.getString(CreateUserRequest.PASSWORD_KEY);
        String email=jsonObject.getString(CreateUserRequest.EMAIL_KEY);

        return new CreateUserRequest(userName, password, email, firstName, lastName);
    }

}
