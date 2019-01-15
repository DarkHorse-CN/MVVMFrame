package com.darkhorse.mvvmframe

import com.darkhorse.mvvmframe.utils.SharePreferencesUtils
import com.darkhorse.mvvmframe.base.BaseApplication

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
class MyApplication : BaseApplication() {
    override fun initUtils() {
        SharePreferencesUtils.init(this,"")
    }
}
