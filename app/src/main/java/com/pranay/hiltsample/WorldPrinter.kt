package com.pranay.hiltsample

import javax.inject.Inject

class WorldPrinter @Inject constructor(){

    fun print(): String{
        print("World")

        return "World"
    }
}