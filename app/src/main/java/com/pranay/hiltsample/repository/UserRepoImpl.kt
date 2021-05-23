package com.pranay.hiltsample.repository

import com.pranay.hiltsample.api.UserApi
import com.pranay.hiltsample.api.model.User
import javax.inject.Inject

class UserRepoImpl @Inject constructor(val api: UserApi): UserRepository {
    override suspend fun fetchRepository(params: String): User {
        return api.getUserDetails(params)
    }

}