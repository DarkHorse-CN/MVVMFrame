package com.darkhorse.mvvmframe.mvvm

import android.arch.lifecycle.ViewModel

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseViewModel<D> : ViewModel() {

    val mData by lazy {
        createData()
    }

    protected abstract fun createData(): D

}
