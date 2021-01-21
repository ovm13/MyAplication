package com.example.myapplication;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class UserUtils {

    public User getUser(){
        String jsonStr = Connection.getUserJson("https://randomuser.me/api/1.1");
        return parseJsonToUser(jsonStr);
    }

    private User parseJsonToUser(String json){
        User user = new User();

        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            JSONObject jsonObjectResult = jsonArray.getJSONObject(0);

            user.setName(jsonObjectResult.getJSONObject("name").getString("first"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }


}
