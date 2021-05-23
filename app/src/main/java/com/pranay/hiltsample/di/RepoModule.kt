package com.pranay.hiltsample.di

import com.pranay.hiltsample.repository.UserRepoImpl
import com.pranay.hiltsample.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepoModule {

    @Binds
    abstract fun providesUserRepository(userRepositoryImpl: UserRepoImpl) : UserRepository
}