package com.akshay.quarguard.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/
data class SignUpRequest(
    @Expose
    @SerializedName("name1")
    var name1: String,

    @Expose
    @SerializedName("name2")
    var name2: String,

    @Expose
    @SerializedName("phoneNumber1")
    var phoneNumber1: String,

    @Expose
    @SerializedName("phoneNumber2")
    var phoneNumber2: String,

    @Expose
    @SerializedName("password")
    var password: String,

    @Expose
    @SerializedName("age")
    var age: Int,

    @Expose
    @SerializedName("gender")
    var gender: String

)