package com.twu.biblioteca;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MovieList {

    private Movie[] movieMessage;

    public MovieList(String path){
        String JsonContext = new ReadJson().ReadFile(path);
        JSONArray movieListMessage = JSONArray.fromObject(JsonContext);
        int listLength = movieListMessage.size();
        Movie[] movieInfo = new Movie[listLength];
        for (int i = 0; i < listLength; i++){
            JSONObject jsonObject = movieListMessage.getJSONObject(i);
            movieInfo[i] = new Movie(jsonObject.get("name").toString(),jsonObject.getInt("year"),jsonObject.get("director").toString(),jsonObject.getDouble("movie rating"));
        }
        this.movieMessage = movieInfo;
    }

    public void listMovieMessage(){
        int listLength = movieMessage.length;
        System.out.println("******************\n" + "----Movie List----\n" + "******************");
        for (int i=0;i<listLength;i++){
            System.out.println("name:"+movieMessage[i].getName()+", year:"+movieMessage[i].getYear()+", director:"+movieMessage[i].getDirector()+", movie rating:"+movieMessage[i].getRate());
        }
    }
}
