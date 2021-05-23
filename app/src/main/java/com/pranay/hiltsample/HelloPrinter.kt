package com.pranay.hiltsample

import android.app.Application
import android.content.Context
import com.pranay.hiltsample.di.AppDependencyResolver
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HelloPrinter @Inject constructor(  @ApplicationContext
                                         val context: Context){

    fun print(): String{
        print("Hello")
        val fromApplication = EntryPointAccessors.fromApplication(context, AppDependencyResolver::class.java)
        return fromApplication.getWorldPrinter().print()
    }
}