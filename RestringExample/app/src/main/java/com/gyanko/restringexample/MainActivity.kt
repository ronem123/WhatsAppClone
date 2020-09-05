package com.gyanko.restringexample

import android.content.Intent
import android.os.Build
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : BaseActivity() {
    lateinit var btnEn: TextView
    lateinit var btnNp: TextView
    lateinit var btnBn: TextView

    override fun getRootView() = R.layout.activity_main


    override fun initiate() {
        btnEn = findViewById(R.id.btnEn)
        btnNp = findViewById(R.id.btnNp)
        btnBn = findViewById(R.id.btnBn)

        btnEn.setOnClickListener { loadLanguage("en") }
        btnNp.setOnClickListener { loadLanguage("np") }
        btnBn.setOnClickListener { loadLanguage("bn") }
    }

    private fun loadLanguage(lng: String) {
        val locale = Locale(lng)
        Locale.setDefault(locale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Toast.makeText(this, "Is build greater equal to N", Toast.LENGTH_SHORT).show()
            val configuration = this.resources.configuration;
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)
            this.createConfigurationContext(configuration)
        }

        recreate()
//        val intent = Intent(this, SecondPage::class.java)
//        startActivity(intent)
    }

//    override fun attachBaseContext(newBase: Context?) {
//        Log.v("Called","attachBaseContext")
//        super.attachBaseContext(Restring.wrapContext(newBase))
//    }
}
