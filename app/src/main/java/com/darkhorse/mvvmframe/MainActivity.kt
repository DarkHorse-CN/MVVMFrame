package com.darkhorse.mvvmframe

import android.content.Intent
import android.view.View
import com.darkhorse.baseframe.BaseActivity
import com.darkhorse.mvvmframe.ui.OrderActivity


class MainActivity : BaseActivity(), View.OnClickListener {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    override fun initView() {
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, OrderActivity::class.java))
    }
}

