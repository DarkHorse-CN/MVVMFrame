package com.darkhorse.mvvmframe

import com.darkhorse.mvvmframe.databinding.ActivityMainBinding
import com.darkhorse.mvvmframe.entity.TestEntity
import com.darkhorse.mvvmframe.mvvm.model.TestModel
import com.darkhorse.mvvmframe.mvvm.viewmodel.TestViewModel

class MainActivity : BaseMvvmActivity<TestEntity, TestModel, TestViewModel,ActivityMainBinding>() {

    override fun updateData(bean: TestEntity?) {
        mBinding.test = bean
    }

    override fun createViewModel(): TestViewModel = TestViewModel()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
        mViewModel.initData()
    }

    override fun initView() {
    }

}
