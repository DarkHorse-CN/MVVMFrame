package com.darkhorse.mvvmframe

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseViewModel<E, M : BaseModel> : ViewModel() {
    protected val mModel by lazy {
        createModel()
    }

    val mLiveData by lazy {
        MutableLiveData<E>()
    }

    protected abstract fun createModel(): M


}
