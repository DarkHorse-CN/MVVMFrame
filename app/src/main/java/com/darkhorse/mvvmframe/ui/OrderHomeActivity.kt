package com.darkhorse.mvvmframe.ui

import com.darkhorse.mvvmframe.BaseMVVMActivity
import com.darkhorse.mvvmframe.R
import com.darkhorse.mvvmframe.databinding.OrderHomeActivityBinding
import com.darkhorse.mvvmframe.mvvm.data.OrderHomeData
import com.darkhorse.mvvmframe.mvvm.model.OrderHomeModel
import com.darkhorse.mvvmframe.mvvm.viewmodel.OrderHomeViewModel

import kotlinx.android.synthetic.main.activity_order_home.*

class OrderHomeActivity : BaseMVVMActivity<OrderHomeData, OrderHomeModel, OrderHomeViewModel, OrderHomeActivityBinding>() {

    override fun createViewModel() = OrderHomeViewModel()

    override fun getLayoutId(): Int = R.layout.activity_order_home

    override fun initView() {
    }

    override fun initData() {
    }

    override fun updateData(binding: OrderHomeActivityBinding, bean: OrderHomeData) {
    }
}
