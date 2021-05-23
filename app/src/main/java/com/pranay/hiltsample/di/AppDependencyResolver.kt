package com.pranay.hiltsample.di

import com.pranay.hiltsample.WorldPrinter
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface AppDependencyResolver {
    fun getWorldPrinter(): WorldPrinter
}