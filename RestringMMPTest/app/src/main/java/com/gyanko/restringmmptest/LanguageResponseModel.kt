package com.gyanko.restringmmptest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Lanugage {

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
class Language(var id: Int, var name: String, var code: String, var imageUrl: String)


