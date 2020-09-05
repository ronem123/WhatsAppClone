package com.gyanko.restringexample

import android.app.Application
import com.ice.restring.Restring
import com.ice.restring.RestringConfig


/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 3/24/2020.
 * Programmed on Dell Xps 15 9560
 */
class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Restring.init(
            applicationContext,
            RestringConfig.Builder()
                .persist(true)
                .stringsLoader(StringLoader())
                .build()
        )

    }
}
