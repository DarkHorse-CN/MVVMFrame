package com.darkhorse.mvvmframe

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import com.darkhorse.baseframe.BaseFragment

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseMVVMFragment<D, M : BaseModel, VM : BaseViewModel<D, M>, B : ViewDataBinding> : BaseFragment() {

    protected val mViewModel by lazy {
        ViewModelProviders.of(this).get(createViewModel()::class.java)
    }

    protected val mBinding by lazy {
        DataBindingUtil.inflate<B>(layoutInflater, getLayoutId(), null, false)
    }

    protected abstract fun createViewModel(): VM

    override fun getRootView(): View {
        return mBinding.root
    }
}
