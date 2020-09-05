package com.gyanko.restringmmptest

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ice.restring.Restring

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 4/16/2020.
 * Programmed on Dell Xps 15 9560
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLanguage()
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId(): Int

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(Restring.wrapContext(newBase))
    }
}