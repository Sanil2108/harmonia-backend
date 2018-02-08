package com.sanilk;

import com.sanilk.hibernate_classes.playlist.Playlist;
import com.sanilk.hibernate_classes.song.Song;
import com.sanilk.hibernate_classes.song.SongHandler;
import com.sanilk.hibernate_classes.user.User;
import com.sanilk.hibernate_classes.user.UserHandler;
import com.sanilk.requests.*;
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
import java.io.DataOutputStream;
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
        DataOutputStream dos=new DataOutputStream(resp.getOutputStream());
        switch (request.requestType){
            case CreateUserRequest.REQUEST_TYPE:
                CreateUserRequest createUserRequest=(CreateUserRequest)request;
                userHandler.saveUser(new User(createUserRequest.getUserName(),
                        createUserRequest.getPassword(),
                        createUserRequest.getEmail()));

//                userHandler.populateList();
//
//                userHandler.getUser("abcd");

                JSONObject jsonObject=new JSONObject();
                jsonObject.put("response_type", "CREATE_USER_RESPONSE");
                jsonObject.put("successful", true);
                jsonObject.put("error_code", -1);
                jsonObject.put("error_details", "none");

                String response=jsonObject.toString();
                dos.writeUTF(response);

                break;

            case AuthenticateRequest.REQUEST_TYPE:
                AuthenticateRequest authenticateRequest=(AuthenticateRequest)request;

                JSONObject authJSONObject=new JSONObject();
                authJSONObject.put("response_type", "AUTHENTICATE_RESPONSE");
                authJSONObject.put("successful", true);
                authJSONObject.put("error_code", -1);
                authJSONObject.put("error_details", "none");

                User user=userHandler.getUser(authenticateRequest.getUserName());
                if(user!=null && user.getPassword().equals(authenticateRequest.getPassword())){
                    authJSONObject.put("authentic", true);
                }else{
                    authJSONObject.put("authentic", false);
                }

                String authResponse=authJSONObject.toString();
                dos.writeUTF(authResponse);

                break;

            case CreatePlaylistRequest.REQUEST_TYPE:
                CreatePlaylistRequest createPlaylistRequest=(CreatePlaylistRequest)request;

                JSONObject createPlaylistJSONObject=new JSONObject();
                //Write response here

                String createPlaylistResponse=createPlaylistJSONObject.toString();
                dos.writeUTF(createPlaylistResponse);

                break;

            case NewSongRequest.REQUEST_TYPE:
                NewSongRequest newSongRequest=(NewSongRequest)request;

                JSONObject newSongJSONObject=new JSONObject();

                SongHandler songHandler=new SongHandler();
                songHandler.saveSong(new Song(
                        newSongRequest.getName(),
                        newSongRequest.getArtist()
                ));

                dos.writeUTF(newSongJSONObject.toString());
                break;
        }
    }
}
