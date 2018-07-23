package com.darkhorse.mvvmframe

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Observable

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseViewModel<D, M : BaseModel> : ViewModel() {
    protected val mModel by lazy {
        createModel()
    }

    internal val mLiveData by lazy {
        MutableLiveData<D>()
    }

    protected abstract fun createModel(): M

    protected fun updateData(data: D) {
        mLiveData.value = data
    }

}
