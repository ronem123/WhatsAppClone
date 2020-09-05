package com.gyanko.stringbundle

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 4/15/2020.
 * Programmed on Dell Xps 15 9560
 */
 class StringBundle(private val context: Context) {

    fun loadLanguageFile(fileName: String) {
        context.getJsonString(fileName)?.let {
            Log.v("LanguageData",it)
            context.startMultiLanguageOperation(it)
        }
    }

    fun recreateView(viewGroup: ViewGroup) {
        val map = getHashMap(context,"ne")

        map?.let {storage->
            for(i in 0 until viewGroup.childCount){
                val v = viewGroup.getChildAt(i)
                if(v is ViewGroup){

                }else if(v is androidx.appcompat.widget.AppCompatTextView){

//                    https://stackoverflow.com/questions/41263515/access-textview-string-resource-name-programmatically

                    val value = v.text.toString()
                    val stringName = v.resources.getIdentifier(value,"string",context.packageName);
//                    setTextForView(
//                        view,
//                        resources.getString(attrs.getAttributeResourceValue(index, 0))
//                    )

                }
            }
        }
    }
}