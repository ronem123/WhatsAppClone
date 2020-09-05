package com.gyanko.restringmmptest;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConstantMethods {

    public static void saveLanguageList(Context context, ArrayList<Lanugage> list, String key) {
        List<Lanugage> oldList = getLanguageList(context, key);
        List<Lanugage> duplicate = new ArrayList<>();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    public static List<Lanugage> getLanguageList(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);

        Type type = new TypeToken<List<Lanugage>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public static void saveListOfString(Context context, List<String> list, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    public static List<String> getListOfString(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);

        Type type = new TypeToken<List<String>>() {
        }.getType();
        return gson.fromJson(json, type);
    }


    /**
     * Save and get HashMap in SharedPreference
     */

    public static void saveHashMap(Context context, String key, Map<String, String> obj) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }


    public static Map<String, String> getHashMap(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, "");
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> obj = gson.fromJson(json, type);
        return obj;
    }
}
