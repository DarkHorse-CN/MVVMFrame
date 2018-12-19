package com.darkhorse.mvvmframe.interfaces

interface IBaseActivity {
    fun getLayoutId(): Int

    fun initView()

    fun initData()
}
