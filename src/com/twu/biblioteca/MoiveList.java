package com.twu.biblioteca;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MoiveList {

    private Moive[] moiveMessage;

    public MoiveList(String path){
        String JsonContext = new ReadJson().ReadFile(path);
        JSONArray moiveListMessage = JSONArray.fromObject(JsonContext);
        int listLength = moiveListMessage.size();
        Moive[] moiveInfo = new Moive[listLength];
        for (int i = 0; i < listLength; i++){
            JSONObject jsonObject = moiveListMessage.getJSONObject(i);
            moiveInfo[i] = new Moive(jsonObject.get("name").toString(),jsonObject.getInt("year"),jsonObject.get("director").toString(),jsonObject.getDouble("rate"));
        }
        this.moiveMessage = moiveInfo;
    }

}
