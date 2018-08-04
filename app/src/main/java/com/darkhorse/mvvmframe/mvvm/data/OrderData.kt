package com.darkhorse.mvvmframe.mvvm.data

import android.arch.lifecycle.MutableLiveData

data class OrderData(
        var mNum : MutableLiveData<Int> = MutableLiveData()
)
