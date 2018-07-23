package com.darkhorse.mvvmframe.mvvm.model

import com.darkhorse.mvvmframe.BaseModel
import com.darkhorse.mvvmframe.mvvm.data.OrderHomeData

class OrderHomeModel : BaseModel() {

    fun addNum(num: Int): OrderHomeData = OrderHomeData(num + 1)
}