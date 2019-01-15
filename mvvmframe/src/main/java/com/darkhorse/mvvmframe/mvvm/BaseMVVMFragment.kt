package com.darkhorse.mvvmframe.mvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darkhorse.mvvmframe.base.BaseFragment
import java.lang.reflect.ParameterizedType

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseMVVMFragment<D, VM : BaseViewModel<D>, B : ViewDataBinding> : BaseFragment() {

    protected lateinit var mViewModel: VM
    protected lateinit var mBinding: B

    override fun getRootView(): View = mBinding.root

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate<B>(layoutInflater, getLayoutId(), container, false)
                .apply {
                    setLifecycleOwner(viewLifecycleOwner)
                }
        mViewModel = ViewModelProviders.of(this).get((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>)
        initDataBinding()
        return mBinding.root
    }

    abstract fun initDataBinding()
}
