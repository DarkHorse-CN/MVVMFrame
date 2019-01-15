package com.darkhorse.mvvmframe.base

import android.support.multidex.MultiDexApplication
import com.darkhorse.mvvmframe.utils.AppManager

/**
 * Description:
 * Created by DarkHorse on 2018/5/18.
 */
abstract class BaseApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        initUtils()
        AppManager.init(this)
    }

    abstract fun initUtils()

}
