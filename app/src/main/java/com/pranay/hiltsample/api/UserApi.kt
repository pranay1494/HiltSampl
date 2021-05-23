package com.pranay.hiltsample.api

import com.pranay.hiltsample.api.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") userName: String) : User
}