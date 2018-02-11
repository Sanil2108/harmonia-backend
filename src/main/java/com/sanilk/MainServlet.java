package com.sanilk;

import com.sanilk.hibernate_classes.genre.Genre;
import com.sanilk.hibernate_classes.playlist.Playlist;
import com.sanilk.hibernate_classes.playlist.PlaylistHandler;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;


public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JSONParser jsonParser=new JSONParser();

        String requestText=new DataInputStream(req.getInputStream()).readUTF();
        MyRequest request=jsonParser.parse(requestText);
        DataOutputStream dos=new DataOutputStream(resp.getOutputStream());
        switch (request.requestType){
            case CreateUserRequest.REQUEST_TYPE:

                UserHandler userHandler=new UserHandler();
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

                UserHandler userHandler2=new UserHandler();
                User user=userHandler2.getUser(authenticateRequest.getUserName());
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

                PlaylistHandler playlistHandler=new PlaylistHandler();

                String playlistName=createPlaylistRequest.getPlaylistName();
                String genres="temp_genres";
                int points=-1;

                Set<Song> songsArr=new HashSet<>();
                CreatePlaylistRequest.Song[] songs=createPlaylistRequest.getSongs();

                Playlist playlist=new Playlist(playlistName, genres, points, new HashSet<>());

                for(int i=0;i<songs.length;i++){
                    String tempName=songs[i].getName();
                    String tempArtist=songs[i].getArtist();
                    String id=songs[i].getLink();
                    Song temp=new Song(tempName, id, tempArtist, playlist, new HashSet<>());

                    Set<Genre> genresArr=new HashSet<>();
                    CreatePlaylistRequest.Song.Genre[] tempGenres=
                             songs[i].getGenres();
                    for(int j=0;j<tempGenres.length;j++){
                        Genre temptempgenre=new Genre(
                                tempGenres[j].getName(),
                                temp
                        );
                        genresArr.add(temptempgenre);
                    }

                    temp.genres=genresArr;
                    songsArr.add(temp);
                }

                playlist.songSet=songsArr;
                playlistHandler.savePlaylist(playlist);

                JSONObject createPlaylistJSONObject=new JSONObject();
                //Write response here

                String createPlaylistResponse=createPlaylistJSONObject.toString();
                dos.writeUTF(createPlaylistResponse);

                break;

//            case NewSongRequest.REQUEST_TYPE:
//                NewSongRequest newSongRequest=(NewSongRequest)request;
//
//                JSONObject newSongJSONObject=new JSONObject();
//
//                SongHandler songHandler=new SongHandler();
//
//                HashSet<Genre> genres2=new HashSet<>();
//                for(NewSongRequest.Genre g:newSongRequest.getGenres()) {
//                    Genre g2=new Genre(g.getName(), s);
//                    genres2.add(g2);
//                }
//                Song s=new Song(
//                        newSongRequest.getName(),
//                        newSongRequest.getId(),
//                        newSongRequest.getArtist(),
//                        playlist,
//                        genres2
//                );
//                s.genres=genres2;
//                songHandler.saveSong(s);
//
//                dos.writeUTF(newSongJSONObject.toString());
//                break;
        }
    }
}
