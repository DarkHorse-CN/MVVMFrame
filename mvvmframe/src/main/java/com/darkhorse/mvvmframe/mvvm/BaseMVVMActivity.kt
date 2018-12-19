package com.darkhorse.mvvmframe.mvvm

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.darkhorse.mvvmframe.base.BaseActivity

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseMVVMActivity<D, VM : BaseViewModel<D>, B : ViewDataBinding> : BaseActivity() {

    protected lateinit var mViewModel: VM
    protected lateinit var mBinding: B

    protected abstract fun createViewModel(): VM

    override fun getContentView(): View = mBinding.root

    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding = DataBindingUtil.setContentView<B>(mActivity, getLayoutId())
                .apply {
                    setLifecycleOwner(this@BaseMVVMActivity)
                }
        mViewModel = ViewModelProviders.of(this).get(createViewModel()::class.java)

        initDataBinding()
        super.onCreate(savedInstanceState)
    }

    abstract fun initDataBinding()

}
