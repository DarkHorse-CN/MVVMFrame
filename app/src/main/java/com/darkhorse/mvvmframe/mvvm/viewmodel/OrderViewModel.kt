package com.darkhorse.mvvmframe.mvvm.viewmodel

import com.darkhorse.mvvmframe.mvvm.BaseViewModel
import com.darkhorse.mvvmframe.mvvm.data.OrderData

class OrderViewModel : BaseViewModel<OrderData>() {
    override fun createData(): OrderData = OrderData()

}
