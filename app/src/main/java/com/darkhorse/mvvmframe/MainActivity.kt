package com.darkhorse.mvvmframe

import android.view.View
import com.darkhorse.baseframe.BaseActivity


class MainActivity : BaseActivity(), View.OnClickListener {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    override fun initView() {
    }

    override fun onClick(v: View?) {
        startActivity(TestActivity::class.java)
    }
}

