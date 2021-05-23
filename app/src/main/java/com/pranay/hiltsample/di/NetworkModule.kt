package com.pranay.hiltsample.di

import com.pranay.hiltsample.BuildConfig
import com.pranay.hiltsample.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient,converterFactory: Converter.Factory, @Named("baseurl")baseUrl : String ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .baseUrl(baseUrl)
            .build()
    }


    @Singleton
    @Provides
    internal fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Singleton
    @Provides
    internal fun provideConvertorFactory() : Converter.Factory = GsonConverterFactory.create()

    @Named("baseurl")
    @Singleton
    @Provides
    internal fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    internal fun provideUserApi(retrofit: Retrofit) = retrofit.create(UserApi::class.java)
}