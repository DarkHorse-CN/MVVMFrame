package com.darkhorse.mvvmframe

import android.arch.lifecycle.ViewModel
import android.databinding.ViewDataBinding

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseViewModel<D, M : BaseModel> : ViewModel() {
    protected val mModel by lazy {
        createModel()
    }

    val mData by lazy {
        createData()
    }

    protected abstract fun createData(): D

    protected abstract fun createModel(): M
}
