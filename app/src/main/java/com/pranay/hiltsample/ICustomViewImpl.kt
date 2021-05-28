package com.pranay.hiltsample

import com.pranay.customviews.ICustomView

class ICustomViewImpl: ICustomView {
    override fun getPrintableText(): String {
        return "pranay"
    }
}