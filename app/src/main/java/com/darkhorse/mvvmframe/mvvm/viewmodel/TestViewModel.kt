package com.darkhorse.mvvmframe.mvvm.viewmodel

import com.darkhorse.mvvmframe.BaseViewModel
import com.darkhorse.mvvmframe.entity.Test2Bean
import com.darkhorse.mvvmframe.entity.TestEntity
import com.darkhorse.mvvmframe.mvvm.model.TestModel

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
class TestViewModel : BaseViewModel<TestEntity, TestModel>() {
    override fun createModel() = TestModel()

    fun initData() {
        mModel.initData()
        mLiveData.value = TestEntity(Test2Bean("title","content"))
    }

    fun updateData() {
        mModel.updateData()
    }
}
