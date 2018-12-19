package com.darkhorse.mvvmframe.extension

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import com.darkhorse.mvvmframe.base.BaseActivity
import com.darkhorse.mvvmframe.base.BaseFragment
import com.darkhorse.mvvmframe.utils.AppManager
import android.view.WindowManager
import android.os.Build
import android.view.View

/**
 * Description:
 * Created by DarkHorse on 2018/7/23.
 */
fun BaseActivity.startActivity(clz: Class<out Activity>, bundle: Bundle? = null, isFinished: Boolean = false) {
    AppManager.startActivity(this, clz, bundle, isFinished)
}

fun BaseActivity.startActivityForResult(clz: Class<out Activity>, requestCode: Int, bundle: Bundle? = null) {
    AppManager.startActivityForResult(this, clz, requestCode, bundle)
}

fun BaseActivity.startBrowser(url: String) {
    AppManager.startBrowser(this, url)
}

fun BaseFragment.startActivity(clz: Class<out BaseActivity>, bundle: Bundle? = null, isFinished: Boolean = false) {
    AppManager.startActivity(this.mActivity, clz, bundle, isFinished)
}

fun BaseFragment.startActivityForResult(clz: Class<out BaseActivity>, requestCode: Int, bundle: Bundle? = null) {
    AppManager.startActivityForResult(this.mActivity, clz, requestCode, bundle)
}

fun BaseFragment.startBrowser(url: String) {
    AppManager.startBrowser(this.mActivity, url)
}

fun BaseActivity.setImmersion() {
    if (AppManager.greaterThanSdkVersion(Build.VERSION_CODES.LOLLIPOP)) {
        val window = window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }
}