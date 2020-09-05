package com.ice.restring;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

class RestringUtil {

    static String getCurrentLanguage(Resources resources) {
        String lang;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            lang= resources.getConfiguration().getLocales().get(0).getLanguage();
        } else {
            //noinspection deprecation
            lang = resources.getConfiguration().locale.getLanguage();
        }
//        Log.v("Called Internally", "Language : " + lang);

        return lang;
    }
}
