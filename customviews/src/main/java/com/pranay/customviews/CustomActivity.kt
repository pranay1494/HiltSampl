package com.pranay.customviews

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.layout.*
import javax.inject.Inject

@AndroidEntryPoint
class CustomActivity: AppCompatActivity() {

    @Inject
    lateinit var iCustomView: ICustomView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        tvName.text = iCustomView.getPrintableText()
    }

    companion object{
        fun createIntent(context: Context) = Intent(context,CustomActivity::class.java)
    }
}