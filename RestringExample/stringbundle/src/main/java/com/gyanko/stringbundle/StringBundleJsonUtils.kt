package com.gyanko.stringbundle

import android.content.Context
import android.util.Log
import java.io.InputStream

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 4/15/2020.
 * Programmed on Dell Xps 15 9560
 */

fun Context.getJsonString(filename: String): String? {
    val json: String?
    return try {
        val inputStream: InputStream = applicationContext.assets.open(filename)
        json = inputStream.bufferedReader().use { it.readText() }
        json
    } catch (ex: Exception) {
        ex.printStackTrace()
        Log.e("Exception", "File write failed: $ex")
        null
    }
}