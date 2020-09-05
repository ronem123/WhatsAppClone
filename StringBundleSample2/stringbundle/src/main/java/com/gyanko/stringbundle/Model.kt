package com.gyanko.stringbundle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ram Mandal(ram.mandal@8squarei.com) on 4/15/2020.
 * Programmed on Dell Xps 15 9560
 */

class Language{
        @SerializedName("Id")
        @Expose
        var id: Int? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("status")
        @Expose
        var status: Boolean? = null
        @SerializedName("imageName")
        @Expose
        var imageName: String? = null
        @SerializedName("imageUrl")
        @Expose
        var imageUrl: String? = null
        @SerializedName("code")
        @Expose
        var code: String? = null
        @SerializedName("version")
        @Expose
        var version: String? = null
}