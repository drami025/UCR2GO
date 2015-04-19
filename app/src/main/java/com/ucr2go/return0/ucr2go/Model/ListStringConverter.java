package com.ucr2go.return0.ucr2go.Model;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by daniel on 4/19/15.
 */
public class ListStringConverter {

    public static String listToString(List<Node> list){
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public static List<Node> stringToList(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }
}
