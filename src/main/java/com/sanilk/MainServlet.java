package com.sanilk;

import com.sanilk.hibernate_classes.user.User;
import com.sanilk.hibernate_classes.user.UserHandler;
import com.sanilk.requests.CreateUserRequest;
import com.sanilk.requests.MyRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;


public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserHandler userHandler=new UserHandler();

        JSONParser jsonParser=new JSONParser();

        String requestText=new DataInputStream(req.getInputStream()).readUTF();
        MyRequest request=jsonParser.parse(requestText);
        switch (request.requestType){
            case CreateUserRequest.REQUEST_TYPE:
                CreateUserRequest createUserRequest=(CreateUserRequest)request;
                userHandler.saveUser(new User(createUserRequest.getUserName(),
                        createUserRequest.getPassword(),
                        createUserRequest.getEmail()));

                userHandler.populateList();

                userHandler.getUser("abcd");

                String response="response";
                resp.getOutputStream().write(response.getBytes());

                break;
        }

    }
}
