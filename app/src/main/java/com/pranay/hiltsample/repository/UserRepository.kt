package com.pranay.hiltsample.repository

import com.pranay.hiltsample.api.model.User

interface UserRepository {
    suspend fun fetchRepository(params: String) : User
}