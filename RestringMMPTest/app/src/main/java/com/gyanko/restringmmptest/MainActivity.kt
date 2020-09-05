package com.gyanko.restringmmptest

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.gyanko.restringmmptest.kotlin.DecimalFormat
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*


class MainActivity : BaseActivity() {

    fun convertToTwoDecimalPoints(double: Double?): String? {
        val nf = NumberFormat.getNumberInstance(Locale.ENGLISH)
        val formatter = nf as java.text.DecimalFormat
        formatter.roundingMode = RoundingMode.DOWN
        formatter.applyPattern("#0.00")
        return formatter.format(double)
    }

    private var edt1: EditText? = null

    private var watcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            edt1?.removeTextChangedListener(this)

            val cursorPoint = edt1?.selectionEnd?:0

            var value = s.toString()
            value = value.replace(",","")

            if (value.isNotEmpty()) {
                val doubleValue = value.toDouble()
                edt1?.setText(convertToTwoDecimalPoints(doubleValue))
                edt1?.setSelection(cursorPoint)
            }
            edt1?.addTextChangedListener(this)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLanguage()

        checkLanguage()

        val btnBengali = findViewById<Button>(R.id.btnBengali)
        val btnNepali = findViewById<Button>(R.id.btnNepali)
        val btnEnglish = findViewById<Button>(R.id.btnEnglish)
        val btnTamil = findViewById<Button>(R.id.btnTamil)

        edt1 = findViewById(R.id.edt1)
//        edt1?.filters = (arrayOf<InputFilter>(DecimalFormat(10, 2)))
        edt1?.addTextChangedListener(watcher)

        btnBengali.setOnClickListener {
            UserInfo.languageCode = "bn"
            loadLanguage()
            startActivity()

        }
        btnNepali.setOnClickListener {
            UserInfo.languageCode = "np"
            loadLanguage()
            startActivity()

        }
        btnEnglish.setOnClickListener {
            UserInfo.languageCode = "en"
            loadLanguage()
            startActivity()

        }
        btnTamil.setOnClickListener {
            UserInfo.languageCode = "ta"
            loadLanguage()
            startActivity()
        }
    }

    private fun startActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    override fun getLayoutId(): Int = R.layout.activity_main


    private fun checkLanguage() {
        if (UserInfo.languageVersion.toInt() < Constants.LATEST_LANGUAGE_VERSION) {
            val languageData = getData("language_multi_mmp.txt")
            Log.v("Language", languageData.toString())
            if (languageData.isNotEmptyorNull()) {
                startMultiLanguageOperation(languageData!!)
            }
        }
    }

}
