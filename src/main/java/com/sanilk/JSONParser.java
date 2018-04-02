package com.sanilk;

import com.sanilk.hibernate_classes.playlist.Playlist;
import com.sanilk.requests.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {

    public MyRequest parse(String text){
        JSONObject jsonObject=new JSONObject(text);
        String typeOfRequest=jsonObject.getString(MyRequest.REQUEST_TYPE_KEY);
        switch (typeOfRequest){
            case CreateUserRequest.REQUEST_TYPE:
                return parseCreateUserRequest(jsonObject);
            case AuthenticateRequest.REQUEST_TYPE:
                return parseAuthenticateRequest(jsonObject);
            case CreatePlaylistRequest.REQUEST_TYPE:
                return parseCreatePlaylistRequest(jsonObject);
            case NewSongRequest.REQUEST_TYPE:
                return parseNewSongRequest(jsonObject);
            case GetRandomPlaylistRequest.REQUEST_TYPE:
                return parseGetRandomPlaylistRequest(jsonObject);
            case AddCommentRequest.REQUEST_TYPE:
                return parseAddCommentRequest(jsonObject);
            case GetCommentsByPlaylistIdRequest.REQUEST_TYPE:
                return parseGetCommentRequest(jsonObject);
            case PlaylistReactionRequest.REQUEST_TYPE:
                return parsePlaylistReactionRequest(jsonObject);
            case GetNotificationsRequest.REQUEST_TYPE:
                return parseGetNotificationsRequest(jsonObject);
            default:
                return null;
        }
    }

    private GetNotificationsRequest parseGetNotificationsRequest(JSONObject jsonObject){
        String username=jsonObject.getString(GetNotificationsRequest.USERNAME_KEY);

        return new GetNotificationsRequest(username);
    }

    private PlaylistReactionRequest parsePlaylistReactionRequest(JSONObject jsonObject){
        int playlistId=jsonObject.getInt(PlaylistReactionRequest.PLAYLIST_ID_KEY);
        String reaction=jsonObject.getString(PlaylistReactionRequest.REACTION_KEY);

        return new PlaylistReactionRequest(reaction, playlistId);
    }

    private CreateUserRequest parseCreateUserRequest(JSONObject jsonObject){
        String userName=jsonObject.getString(CreateUserRequest.USER_NAME_KEY);
        String firstName=jsonObject.getString(CreateUserRequest.FIRST_NAME_KEY);
        String lastName=jsonObject.getString(CreateUserRequest.LAST_NAME_KEY);
        String password=jsonObject.getString(CreateUserRequest.PASSWORD_KEY);
        String email=jsonObject.getString(CreateUserRequest.EMAIL_KEY);

        return new CreateUserRequest(userName, password, email, firstName, lastName);
    }

    private AuthenticateRequest parseAuthenticateRequest(JSONObject jsonObject){
        String username=jsonObject.getString(AuthenticateRequest.USER_NAME_KEY);
        String password=jsonObject.getString(AuthenticateRequest.PASSWORD_KEY);

        return new AuthenticateRequest(username, password);
    }

    private CreatePlaylistRequest parseCreatePlaylistRequest(JSONObject jsonObject){
        String username=jsonObject.getString(CreatePlaylistRequest.USER_NAME_KEY);
        int songsCount=jsonObject.getInt(CreatePlaylistRequest.SONGS_COUNT);
        String playlistName=jsonObject.getString(CreatePlaylistRequest.PLAYLIST_NAME_KEY);
        JSONArray songs=jsonObject.getJSONArray(CreatePlaylistRequest.SONGS_KEY);
        CreatePlaylistRequest.Song[] songsArr=new CreatePlaylistRequest.Song[songsCount];
        for(int i=0;i<songs.length();i++){
            JSONObject tempSong=songs.getJSONObject(i);
            CreatePlaylistRequest.Song song=parseSong(tempSong);
            songsArr[i]=song;
        }

        return new CreatePlaylistRequest(username, songsArr, songsCount, playlistName);
    }

    private CreatePlaylistRequest.Song parseSong(JSONObject jsonObject){
        String link=jsonObject.getString(CreatePlaylistRequest.Song.LINK_KEY);
        String name=jsonObject.getString(CreatePlaylistRequest.Song.NAME_KEY);
        String artist=jsonObject.getString(CreatePlaylistRequest.Song.ARTIST_KEY);
        int genresCount=jsonObject.getInt(CreatePlaylistRequest.Song.GENRES_COUNT_KEY);
        JSONArray genres=jsonObject.getJSONArray(CreatePlaylistRequest.Song.GENRES_KEY);
        CreatePlaylistRequest.Song.Genre[] genresArray=new CreatePlaylistRequest.Song.Genre[genresCount];
        for(int i=0;i<genresCount;i++){
            JSONObject genre=genres.getJSONObject(i);
            CreatePlaylistRequest.Song.Genre temp=parseGenre(genre);
            genresArray[i]=temp;
        }

        return new CreatePlaylistRequest.Song(link, name, genresArray, artist, genresCount);
    }

    private CreatePlaylistRequest.Song.Genre parseGenre(JSONObject jsonObject){
        String name=jsonObject.getString(CreatePlaylistRequest.Song.Genre.NAME_KEY);
        return new CreatePlaylistRequest.Song.Genre(name);
    }

    private NewSongRequest parseNewSongRequest(JSONObject jsonObject){
        String username=jsonObject.getString(NewSongRequest.USER_NAME_KEY);
        String id=jsonObject.getString(NewSongRequest.ID_KEY);
        String name=jsonObject.getString(NewSongRequest.NAME_KEY);
        String artist=jsonObject.getString(NewSongRequest.ARTIST_KEY);
        int genresCount=jsonObject.getInt(NewSongRequest.GENRES_COUNT_KEY);

        JSONArray genres=jsonObject.getJSONArray(NewSongRequest.GENRES_KEY);
        NewSongRequest.Genre[] genresArr=new NewSongRequest.Genre[genresCount];

        for(int i=0;i<genresCount;i++){
            JSONObject temp=genres.getJSONObject(i);
            NewSongRequest.Genre tempGenre=parseNewSongRequestGenre(temp);
            genresArr[i]=tempGenre;
        }

        return new NewSongRequest(username, id, name, artist, genresArr);
    }

    private NewSongRequest.Genre parseNewSongRequestGenre(JSONObject jsonObject){
        String name=jsonObject.getString(NewSongRequest.Genre.NAME_KEY);
        return new NewSongRequest.Genre(name);
    }

    private GetRandomPlaylistRequest parseGetRandomPlaylistRequest(JSONObject jsonObject){
        int genresCount=jsonObject.getInt(GetRandomPlaylistRequest.GENRES_COUNT_KEY);
        JSONArray genresJSONArray=jsonObject.getJSONArray(GetRandomPlaylistRequest.GENRES_KEY);
        String[] genres=new String[genresJSONArray.length()];
        for(int i=0;i<genresJSONArray.length();i++){
            genres[i]=(String)genresJSONArray.get(i);
        }

        return new GetRandomPlaylistRequest(genres, genresCount);
    }

    private GetCommentsByPlaylistIdRequest parseGetCommentRequest(JSONObject jsonObject){
        int playlistId=jsonObject.getInt(GetCommentsByPlaylistIdRequest.PLAYLIST_ID_KEY);

        return new GetCommentsByPlaylistIdRequest(playlistId);
    }

    private AddCommentRequest parseAddCommentRequest(JSONObject jsonObject){
        int playlistId=jsonObject.getInt(AddCommentRequest.PLAYLIST_ID_KEY);
        String username=jsonObject.getString(AddCommentRequest.USERNAME_KEY);
        String text=jsonObject.getString(AddCommentRequest.TEXT_KEY);

        return new AddCommentRequest(username, playlistId, text);
    }

}
