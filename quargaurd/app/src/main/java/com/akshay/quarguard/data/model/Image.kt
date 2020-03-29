package com.akshay.quarguard.data.model

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

data class Image(
    val url: String,
    val headers: Map<String, String>,
    val placeholderWidth: Int = -1,
    val placeholderHeight: Int = -1
)