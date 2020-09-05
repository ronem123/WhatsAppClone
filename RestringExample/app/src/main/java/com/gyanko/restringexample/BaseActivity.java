package com.gyanko.restringexample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ice.restring.Restring;

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 3/29/2020.
 * Programmed on Dell Xps 15 9560
 */
abstract public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootView());
        initiate();
    }

    protected abstract void initiate();

    protected abstract int getRootView();

//    override fun attachBaseContext(newBase: Context?) {
//        Log.v("Called","attachBaseContext")
//        super.attachBaseContext(Restring.wrapContext(newBase))
//    }


    @Override
    protected void attachBaseContext(Context newBase) {
                Log.v("Called","attachBaseContext");

        super.attachBaseContext(Restring.wrapContext(newBase));
    }
}
