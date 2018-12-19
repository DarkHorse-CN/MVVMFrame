package com.darkhorse.mvvmframe.ui

import com.darkhorse.mvvmframe.extension.toast
import com.darkhorse.mvvmframe.mvvm.BaseMVVMActivity
import com.darkhorse.mvvmframe.R
import com.darkhorse.mvvmframe.databinding.OrderActivityBinding
import com.darkhorse.mvvmframe.mvvm.data.OrderData
import com.darkhorse.mvvmframe.mvvm.viewmodel.OrderViewModel

class OrderActivity : BaseMVVMActivity<OrderData, OrderViewModel, OrderActivityBinding>() {

    override fun createViewModel() = OrderViewModel()

    override fun getLayoutId(): Int = R.layout.activity_order

    override fun initDataBinding() {
    }

    override fun initView() {
    }

    override fun initData() {

    }

    fun login() {
        toast("asd")
    }
}
