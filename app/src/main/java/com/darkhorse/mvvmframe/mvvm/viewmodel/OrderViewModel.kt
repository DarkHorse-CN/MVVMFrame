package com.darkhorse.mvvmframe.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.darkhorse.baseframe.extension.v
import com.darkhorse.mvvmframe.BaseViewModel
import com.darkhorse.mvvmframe.databinding.OrderActivityBinding
import com.darkhorse.mvvmframe.mvvm.data.OrderData
import com.darkhorse.mvvmframe.mvvm.model.OrderModel

class OrderViewModel : BaseViewModel<OrderData, OrderModel>() {

    override fun createData(): OrderData = OrderData()

    override fun createModel() = OrderModel()

    init {
        mData.mNum.postValue(0)
    }

    fun addNum(num: Int) {
        mData.mNum.value = num + 1
    }

}
