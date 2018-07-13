package com.darkhorse.mvvmframe.mvvm.viewmodel

import com.darkhorse.mvvmframe.BaseViewModel
import com.darkhorse.mvvmframe.mvvm.data.OrderHomeData
import com.darkhorse.mvvmframe.mvvm.model.OrderHomeModel

class OrderHomeViewModel : BaseViewModel<OrderHomeData, OrderHomeModel>() {
    override fun createModel() = OrderHomeModel()
}
