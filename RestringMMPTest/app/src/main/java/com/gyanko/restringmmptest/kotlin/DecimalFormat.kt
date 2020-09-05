package com.gyanko.restringmmptest.kotlin

import android.text.InputFilter
import android.text.Spanned
import android.text.TextUtils
import java.util.regex.Pattern

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 6/19/2020.
 * Programmed on Dell Xps 15 9560
 */
class DecimalFormat (private var digitsBeforeZero: Int,private var digitsAfterZero: Int) :
    InputFilter {
    /*-?[0-9]{0," + digitsBeforeZero + "}+((\\.[0-9]{0," + digitsAfterZero + "})?)||(\\.)?*/
    /*^\\d{0,4}(?:[.]\\d{0,2})?$*/
    /*"^\\\\d{0," + digitsBeforeZero + "}(?:[.]\\\\d{0," + digitsAfterZero + "})?\$"*/

    private var mPattern: Pattern = Pattern.compile("^\\d{0,4}(?:[.]\\d{0,2})?$")

    override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int, dend: Int): CharSequence? {
        val replacement = source.subSequence(start, end).toString()
        val newVal = (dest.subSequence(0, dstart).toString() + replacement
                + dest.subSequence(dend, dest.length).toString())
        val matcher = mPattern.matcher(newVal)
        if (matcher.matches())
            return null

        return if (TextUtils.isEmpty(source))
            dest.subSequence(dstart, dend)
        else
            dest.subSequence(dstart, dend)
    }

}