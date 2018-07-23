package com.darkhorse.mvvmframe.ui

import com.darkhorse.mvvmframe.BaseMVVMActivity
import com.darkhorse.mvvmframe.R
import com.darkhorse.mvvmframe.databinding.OrderHomeActivityBinding
import com.darkhorse.mvvmframe.mvvm.data.OrderHomeData
import com.darkhorse.mvvmframe.mvvm.model.OrderHomeModel
import com.darkhorse.mvvmframe.mvvm.viewmodel.OrderHomeViewModel

class OrderHomeActivity : BaseMVVMActivity<OrderHomeData, OrderHomeModel, OrderHomeViewModel, OrderHomeActivityBinding>() {

    override fun createViewModel() = OrderHomeViewModel()

    override fun getLayoutId(): Int = R.layout.activity_order_home

    override fun initView() {

    }

    override fun initData() {
        mBinding.data = OrderHomeData(0)
        mBinding.activity = this
    }

    override fun updateData(bean: OrderHomeData) {
        mBinding.data = bean
    }

    fun add(num: Int) {
        mViewModel.addNum(num)
    }
}
