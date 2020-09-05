package com.gyanko.restringmmptest

import android.app.Application
import com.ice.restring.Restring
import com.ice.restring.RestringConfig

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 4/16/2020.
 * Programmed on Dell Xps 15 9560
 */
class MyApplication : Application (){
    override fun onCreate() {
        super.onCreate()

        configureRestring()
    }

    private fun configureRestring() {
        if (UserInfo.languageVersion == "0")
            Restring.init(this,
                RestringConfig.Builder()
                    .persist(true)
                    .build())
        else
            Restring.init(this,
                RestringConfig.Builder()
                    .persist(false)
                    .stringsLoader(MyStringLoader(this.applicationContext))
                    .build())
    }
}