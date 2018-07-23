package com.darkhorse.mvvmframe.mvvm.viewmodel

import com.darkhorse.mvvmframe.BaseViewModel
import com.darkhorse.mvvmframe.mvvm.data.OrderData
import com.darkhorse.mvvmframe.mvvm.model.OrderModel

class OrderViewModel : BaseViewModel<OrderData, OrderModel>() {
    override fun createModel() = OrderModel()
}
