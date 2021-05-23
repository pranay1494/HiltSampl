package com.pranay.hiltsample.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pranay.hiltsample.R
import com.pranay.hiltsample.utils.inTransaction

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_container)
        replaceFragment(savedInstanceState)
    }

    private fun replaceFragment(savedInstanceState: Bundle?) =
        savedInstanceState
            ?: supportFragmentManager.inTransaction { replace(R.id.blank_frame, fragment()) }

    abstract fun fragment(): BaseFragment
}