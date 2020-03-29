package com.akshay.quarguard.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/
data class ImageResponse(

    @Expose
    @SerializedName("statusCode")
    val statusCode: String,

    @Expose
    @SerializedName("status")
    val status: Int,

    @Expose
    @SerializedName("message")
    val message: String,

    @Expose
    @SerializedName("data")
    val data: ImageData
) {
    data class ImageData(

        @Expose
        @SerializedName("imageUrl")
        val imageUrl: String
    )
}