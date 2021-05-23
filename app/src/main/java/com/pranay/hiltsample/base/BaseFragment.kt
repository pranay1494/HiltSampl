package com.pranay.hiltsample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pranay.hiltsample.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {
    @Named("baseurl")
    @Inject lateinit var url: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_base,container,false)
        val baseContainer = view.findViewById<FrameLayout>(R.id.frameContent)
        baseContainer.addView(inflater.inflate(layoutId(),container,false))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().viewStatus.observe(viewLifecycleOwner, Observer{
            when(it){
                ViewStatus.LOADING -> progressBarContainer.visibility = View.VISIBLE
                is ViewStatus.ERROR -> {
                    progressBarContainer.visibility = View.GONE
                    when(it.failure){
                        is Failure.AuthenticationError -> showToast("Authentication error")
                        else -> showToast(it.failure.message)
                    }
                }
                else -> progressBarContainer.visibility = View.GONE
            }
        })
    }

    fun showToast(msg : String){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

    abstract fun getViewModel() : BaseViewModel
    abstract fun layoutId() : Int
}