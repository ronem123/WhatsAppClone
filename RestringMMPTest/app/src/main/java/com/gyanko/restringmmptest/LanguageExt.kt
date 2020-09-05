package com.gyanko.restringmmptest

import android.content.Context
import android.os.Build
import android.util.Log
import com.google.gson.GsonBuilder
import com.gyanko.restringmmptest.ConstantMethods.saveLanguageList
import com.gyanko.restringmmptest.kotlin.KEY_LAANGUAGE_CODE_LIST
import com.gyanko.restringmmptest.kotlin.KEY_LANGUAGE_LIST
import com.ice.restring.Restring
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


fun Context.startMultiLanguageOperation(response: String) {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonObject = JSONObject(response)
    //writeToFile(jsonObject.toString())
//    val code = jsonObject.getString("version")
//    val bodyJSONObject = jsonObject.getJSONObject("Body")

    val code = jsonObject.getString("Code")
    val bodyJSONObject = jsonObject.getJSONObject("Body")

    val version = bodyJSONObject.getString("version")

    val languagesJSONarray = bodyJSONObject.getJSONArray("lanugages")
    val transalationsJSONObject = bodyJSONObject.getJSONObject("translations")


    //update the language version according to the api call
    if (UserInfo.wasApiForMMRemitEligible) {
        UserInfo.mmRemitLanguageVersion = version
    } else {
        UserInfo.languageVersion = version

    }
    val languageList = arrayListOf<Language>()
    val languageCodeList = arrayListOf<String>()

    if (languagesJSONarray != null) {
        for (i in 0 until languagesJSONarray.length()) {
            val languageJSONObject = languagesJSONarray.getJSONObject(i)
            val language = gson.fromJson(languageJSONObject.toString(), Language::class.java)
            var code = language.code
            var imageURL = language.imageUrl
            code = removeSubCode(code)
            language.code = code
            language.imageUrl = imageURL
            languageList.add(language)
            languageCodeList.add(code)
        }

//        val KEY_LANGUAGE_LIST = "KeyLanguageList"
//        val KEY_LAANGUAGE_CODE_LIST = "KeyLanguageCodeList"

        saveLanguageList(this, languageList as ArrayList<Lanugage>, KEY_LANGUAGE_LIST)
        ConstantMethods.saveListOfString(this, languageCodeList, KEY_LAANGUAGE_CODE_LIST)
    }

    for (i in languageList.indices) {
        val languageData = languageList[i]
        var code = languageData.code
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
        var oldDict: MutableMap<String, String>? = ConstantMethods.getHashMap(this, code)
        if (oldDict == null)
            oldDict = HashMap()
        oldDict.putAll(dic)

        Restring.setStrings(code, oldDict)

        ConstantMethods.saveHashMap(this, code, oldDict)
        Log.v("Language Saving","$code")
    }

    //reset the flag if language update was success from
}

fun addSubCode(code: String): String {
    var smallCode = code
    if (smallCode == "in")
        smallCode = "id-ID"
    else if (code == "ms")
        smallCode = "ms-MY"
    else if (code == "ta")
        smallCode = "ta-MY"
    else if (code == "my")
        smallCode = "my-MM"
    return smallCode
}

fun removeSubCode(code: String): String {
    var languageToLoad = code
    if (languageToLoad == "id-ID")
        languageToLoad = "in"
    else if (languageToLoad == "ms-MY")
        languageToLoad = "ms"
    else if (languageToLoad == "ta-MY")
        languageToLoad = "ta"
    else if (languageToLoad == "my-MM")
        languageToLoad = "my"
    return languageToLoad
}

/*
fun Context.startMultiLanguageOperation(response: LanguageListResponse?) {
    val gson = GsonBuilder().setPrettyPrinting().create()
    UserInfo.languageVersion = response?.body?.version.toString()
    val languageList = response?.body?.lanugages
    ConstantMethods.saveLanguageList(this, languageList as ArrayList<Lanugage>, KEY_LANGUAGE_LIST)

    val translations = response?.body?.translations
    val jsonObject = JSONObject(gson.toJson(translations))
    for (i in languageList?.indices!!) {
        val languageData = languageList[i]
        val code = languageData.code
        val dic = JsonUtils.jsonToMap(jsonObject.getJSONObject(code))
        Restring.setStrings(code, dic)
    }
}*/


fun Context.loadLanguage(){
    var languageToLoad = UserInfo.languageCode//get language pref
    languageToLoad = removeSubCode(languageToLoad)

    Log.v("Language Updating","$languageToLoad")
    /*added new*/
    val lockal = Locale(languageToLoad)
    Locale.setDefault(lockal)

    val res = applicationContext.resources
//    val configuration = res.configuration

//    if (Build.VERSION.SDK_INT >= 21) {
//        configuration.setLocale(lockal)
//        configuration.setLayoutDirection(lockal)
//    }else{
//        configuration.locale = lockal
//    }
//
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//        applicationContext.createConfigurationContext(configuration)
//    }
//
//    resources.updateConfiguration(configuration,null)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        val configuration = resources.configuration
        configuration.setLocale(lockal)
        configuration.setLayoutDirection(lockal)
            this.createConfigurationContext(configuration)
            resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}