package com.ucr2go.return0.ucr2go.Model;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * Created by daniel on 4/19/15.
 */
public class HashMapStringConverter {

    public static String hashMapToString(HashMap<Integer, Node> list){
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public static HashMap<Integer, Node> stringToHashMap(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, HashMap.class);
    }
}
