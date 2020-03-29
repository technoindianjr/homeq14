package com.akshay.quarguard.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/
data class SignUpRequest(
    @Expose
    @SerializedName("email")
    var email: String,

    @Expose
    @SerializedName("password")
    var password: String,

    @Expose
    @SerializedName("name")
    var name: String
)