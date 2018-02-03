package com.sanilk.hibernate_classes.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 30/1/18.
 */
public class AllUsers {

    private static AllUsers allUsers=new AllUsers();

    public List<User> users;

    private AllUsers(){
        users=new ArrayList<User>();
    }

    public static AllUsers getAllUsers() {
        return allUsers;
    }

}
