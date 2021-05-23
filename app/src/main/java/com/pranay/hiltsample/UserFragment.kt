package com.pranay.hiltsample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.pranay.hiltsample.base.BaseViewModel
import com.pranay.hiltsample.base.BaseFragment
import com.pranay.hiltsample.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_user.*

@AndroidEntryPoint
class UserFragment: BaseFragment() {
    override fun getViewModel(): BaseViewModel = mViewModel

    override fun layoutId() = R.layout.activity_user

    private val mViewModel by viewModels<UserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        fetchData()
    }

    private fun observeData() {
        mViewModel.getData().observe(viewLifecycleOwner, Observer {
            textView.text = it.name
            imageView.loadImage(it.avatarUrl)
        })

        mViewModel._PrinterData().observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
        })
    }

    fun fetchData() {
        mViewModel.fetchUser("pranay1494")
    }

    companion object {
        fun newInstance() = UserFragment()
    }
}