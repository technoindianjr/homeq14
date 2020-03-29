package com.akshay.quarguard.data.remote

import com.akshay.quarguard.data.remote.request.LoginRequest
import com.akshay.quarguard.data.remote.request.SignUpRequest
import com.akshay.quarguard.data.remote.response.ImageResponse
import com.akshay.quarguard.data.remote.response.InfoResponse
import com.akshay.quarguard.data.remote.response.LoginResponse
import com.akshay.quarguard.data.remote.response.SignUpResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*
import javax.inject.Singleton

/**
 * Created by akshaynandwana on
 * 29, March, 2020
 **/

@Singleton
interface NetworkService {

    @POST(Endpoints.LOGIN)
    fun doLoginCall(
        @Body request: LoginRequest,
        @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<LoginResponse>

    @POST(Endpoints.SIGNUP)
    fun doSignUpCall(
        @Body request: SignUpRequest,
        @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<SignUpResponse>

    @Multipart
    @POST(Endpoints.UPLOAD_IMAGE)
    fun doImageUpload(
        @Part image: MultipartBody.Part,
        @Header(Networking.HEADER_USER_ID) userId: String,
        @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
        @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<ImageResponse>

    @GET(Endpoints.FETCH_INFO)
    fun doFetchInfoCall(
        @Header(Networking.HEADER_USER_ID) userId: String,
        @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
        @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY
    ): Single<InfoResponse>

}
