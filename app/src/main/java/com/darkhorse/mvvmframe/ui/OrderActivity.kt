package com.darkhorse.mvvmframe.ui

import com.darkhorse.mvvmframe.BaseMVVMActivity
import com.darkhorse.mvvmframe.R
import com.darkhorse.mvvmframe.databinding.OrderActivityBinding
import com.darkhorse.mvvmframe.mvvm.data.OrderData
import com.darkhorse.mvvmframe.mvvm.model.OrderModel
import com.darkhorse.mvvmframe.mvvm.viewmodel.OrderViewModel

class OrderActivity : BaseMVVMActivity<OrderData, OrderModel,  OrderViewModel,OrderActivityBinding>() {

    override fun createViewModel() = OrderViewModel()

    override fun getLayoutId(): Int = R.layout.activity_order_home

    override fun initView() {

    }

    override fun initData() {
        mBinding.let {
            it.setLifecycleOwner(this)
            it.mViewModel = mViewModel
            it.mData = mViewModel.mData
        }
    }

}
