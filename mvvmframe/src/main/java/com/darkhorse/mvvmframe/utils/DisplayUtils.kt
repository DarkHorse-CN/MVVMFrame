package com.darkhorse.mvvmframe.utils

import com.darkhorse.mvvmframe.utils.AppManager

object DisplayUtils {
    fun px2dp(pxValue: Float): Float {
        val scale = AppManager.context().resources.displayMetrics.density
        return pxValue / scale + 0.5f
    }

    fun dp2px(dpValue: Float): Float {
        val scale = AppManager.context().resources.displayMetrics.density
        return dpValue * scale + 0.5f
    }

    fun px2dp(pxValue: Int): Int {
        val scale = AppManager.context().resources.displayMetrics.density
        return (pxValue / scale + 0.5).toInt()
    }

    fun dp2px(dpValue: Int): Int {
        val scale = AppManager.context().resources.displayMetrics.density
        return (dpValue * scale + 0.5).toInt()
    }
}
