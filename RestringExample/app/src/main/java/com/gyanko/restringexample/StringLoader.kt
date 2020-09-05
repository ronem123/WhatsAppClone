package com.gyanko.restringexample

import com.ice.restring.Restring


/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 3/24/2020.
 * Programmed on Dell Xps 15 9560
 */
class StringLoader : Restring.StringsLoader {
    override fun getLanguages(): MutableList<String> {
        return mutableListOf("en", "np", "bn")
    }

    override fun getStrings(language: String?): MutableMap<String, String> {
        val map = HashMap<String, String>()

        when (language) {
            "en" -> {
                map["name"]="Name"
                map["address"]="Address"
            }
            "np" -> {
                map["name"]="Naam"
                map["address"]="Thegaana"
            }
            "bn" -> {
                map["name"]="Naam"
                map["address"]="Baari"
            }
        }

        return map
    }

}