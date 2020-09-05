package com.gyanko.stringbundle

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 4/15/2020.
 * Programmed on Dell Xps 15 9560
 */
class StringBundleUtils {

    fun saveLanguageList(
        context: Context?,
        list: ArrayList<Language?>?,
        key: String?
    ) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    fun getLanguageList(
        context: Context?,
        key: String?
    ): List<Language> {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type =
            object : TypeToken<List<Language?>?>() {}.type
        return gson.fromJson(json, type)
    }

    fun saveListOfString(
        context: Context?,
        list: List<String?>?,
        key: String?
    ) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    fun getListOfString(
        context: Context?,
        key: String?
    ): List<String?>? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type =
            object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(json, type)
    }


    /**
     * Save and get HashMap in SharedPreference
     */
    fun saveHashMap(
        context: Context?,
        key: String?,
        obj: Map<String?, String?>?
    ) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(obj)
        editor.putString(key, json)
        editor.apply() // This line is IMPORTANT !!!
    }


    fun getHashMap(
        context: Context?,
        key: String?
    ): Map<String?, String?>? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json = prefs.getString(key, "")
        val type: Type = object :
            TypeToken<Map<String?, String?>?>() {}.type
        return gson.fromJson(json, type)
    }
}