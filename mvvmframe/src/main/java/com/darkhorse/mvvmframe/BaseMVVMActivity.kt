package com.darkhorse.mvvmframe

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseMVVMActivity<D, M : BaseModel, VM : BaseViewModel<D, M>, B : ViewDataBinding> : BaseActivity() {

    protected val mViewModel by lazy {
        ViewModelProviders.of(this).get(createViewModel()::class.java)
    }

    protected val mBinding by lazy {
        DataBindingUtil.setContentView<B>(mContext, getLayoutId())
    }

    protected abstract fun createViewModel(): VM

    override fun getContentView(): View = mBinding.root

}
