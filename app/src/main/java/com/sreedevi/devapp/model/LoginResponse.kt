package com.sreedevi.devapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("user_id")
    @Expose
    var user_id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("school_id")
    @Expose
    var school_id: String? = null
    @SerializedName("auth_token")
    @Expose
    var auth_token: String? = null
}