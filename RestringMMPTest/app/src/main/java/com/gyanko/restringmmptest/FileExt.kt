package com.gyanko.restringmmptest

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStreamWriter

fun writeToFile(data: String) {
    val newData = data.replace("\\s+", "");
    // Get the directory for the user's public pictures directory.
    val path = Environment.getExternalStoragePublicDirectory(
            //Environment.DIRECTORY_PICTURES
            Environment.DIRECTORY_DCIM + "/YourFolder/"
    );

    // Make sure the path directory exists.
    if (!path.exists()) {
        // Make it, if it doesn't exit
        path.mkdirs();
    }

    val file = File(path, "config.txt");

    // Save your stream, don't forget to flush() it before closing it.

    try {
        file.createNewFile();
        val fOut = FileOutputStream(file);
        val myOutWriter = OutputStreamWriter(fOut);
        myOutWriter.append(newData);

        myOutWriter.close();

        fOut.flush();
        fOut.close();
    } catch (e: Exception) {
        Log.e("Exception", "File write failed: " + e.toString());
    }
}

fun Context.getData(filename: String): String? {
    var json: String? = null
    try {
        val inputStream: InputStream = applicationContext.assets.open(filename)
        json = inputStream.bufferedReader().use { it.readText() }
        return json
    } catch (ex: Exception) {
        ex.printStackTrace()
        Log.e("Exception", "File write failed: " + ex.toString())
        return null
    }
}

fun String?.isNotEmptyorNull(): Boolean {
    return this?.isNullOrEmpty() == false
}

