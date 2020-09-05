package com.gyanko.stringbundle

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.io.InputStream

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 4/15/2020.
 * Programmed on Dell Xps 15 9560
 */

fun Context.getJsonString(filename: String): String? {

    return try {
        val inputStream: InputStream = applicationContext.assets.open(filename)
        inputStream.bufferedReader().use { it.readText() }
    } catch (ex: Exception) {
        ex.printStackTrace()
        Log.e("Exception", "File write failed: $ex")
        null
    }
}

fun Context.startMultiLanguageOperation(response: String) {
    val KEY_LANGUAGE_LIST = "KeyLanguageList"
    val KEY_LAANGUAGE_CODE_LIST = "KeyLanguageCodeList"

    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonObject = JSONObject(response)

    val code = jsonObject.getString("Code")
    val bodyJSONObject = jsonObject.getJSONObject("Body")

    val version = bodyJSONObject.getString("version")

    val languagesJSONarray = bodyJSONObject.getJSONArray("lanugages")
    val transalationsJSONObject = bodyJSONObject.getJSONObject("translations")


    val languageList = arrayListOf<Language>()
    val languageCodeList = arrayListOf<String>()

    for (i in 0 until languagesJSONarray.length()) {
        val languageJSONObject = languagesJSONarray.getJSONObject(i)
        val language = gson.fromJson(languageJSONObject.toString(), Language::class.java)
        val imageURL = language.imageUrl
        language.code = removeSubCode(language.code.toString())
        language.imageUrl = imageURL
        languageList.add(language)
        languageCodeList.add(removeSubCode(language.code.toString()))
    }

    saveLanguageList(this, languageList, KEY_LANGUAGE_LIST)
    saveListOfString(this, languageCodeList, KEY_LAANGUAGE_CODE_LIST)

    for (i in languageList.indices) {
        val languageData = languageList[i]
        var code = languageData.code.toString()
        code = addSubCode(code)

        /**
         * check if the language map has empty body
         * if not empty proceed otherwise stop here and continue for next iteration
         */
        val languageTranslation = transalationsJSONObject.getJSONObject(code)
        if (languageTranslation.length() == 0) {
            continue
        }

        /**
         * Add     new key map translation data if not exists or
         * Replace old key map translation data with new one
         */

        val dic = JsonUtils.jsonToMap(languageTranslation)
        code = removeSubCode(code)
        var oldDict: MutableMap<String, String>? = getHashMap(this, code)
        if (oldDict == null)
            oldDict = HashMap()
        oldDict.putAll(dic)

        saveHashMap(this, code, oldDict)
    }
}

fun addSubCode(code: String): String {
    var smallCode = code
    when {
        smallCode == "in" -> smallCode = "id-ID"
        code == "ms" -> smallCode = "ms-MY"
        code == "ta" -> smallCode = "ta-MY"
        code == "my" -> smallCode = "my-MM"
    }
    return smallCode
}

fun removeSubCode(code: String): String {
    var languageToLoad = code
    when (languageToLoad) {
        "id-ID" -> languageToLoad = "in"
        "ms-MY" -> languageToLoad = "ms"
        "ta-MY" -> languageToLoad = "ta"
        "my-MM" -> languageToLoad = "my"
    }
    return languageToLoad
}