package com.akshay.quarguard.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@Parcelize
data class SignUpResponse(
    @Expose
    @SerializedName("statusCode")
    var statusCode: String,

    @Expose
    @SerializedName("status")
    var status: Int,

    @Expose
    @SerializedName("message")
    var message: String,

    @Expose
    @SerializedName("accessToken")
    var accessToken: String,

    @Expose
    @SerializedName("user")
    var userId: User

) : Parcelable {

    @Parcelize
    data class User(

        @Expose
        @SerializedName("name1")
        var userName: String

    ) : Parcelable
}