package com.pranay.hiltsample

import android.os.Bundle
import com.pranay.hiltsample.base.BaseActivity
import com.pranay.hiltsample.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun fragment(): BaseFragment = UserFragment.newInstance()
}