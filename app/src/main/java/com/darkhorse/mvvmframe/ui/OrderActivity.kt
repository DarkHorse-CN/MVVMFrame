package com.darkhorse.mvvmframe.ui

import com.darkhorse.baseframe.extension.toast
import com.darkhorse.mvvmframe.BaseMVVMActivity
import com.darkhorse.mvvmframe.R
import com.darkhorse.mvvmframe.databinding.OrderActivityBinding
import com.darkhorse.mvvmframe.mvvm.data.OrderData
import com.darkhorse.mvvmframe.mvvm.model.OrderModel
import com.darkhorse.mvvmframe.mvvm.viewmodel.OrderViewModel

import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : BaseMVVMActivity<OrderData, OrderModel, OrderViewModel, OrderActivityBinding>() {

    override fun createViewModel() = OrderViewModel()

    override fun getLayoutId(): Int = R.layout.activity_order

    override fun initView() {
    }

    override fun initData() {
        mBinding.activity = this
    }

    override fun updateData(binding: OrderActivityBinding, bean: OrderData) {
    }

    fun login(){
        toast("asd")
    }
}
