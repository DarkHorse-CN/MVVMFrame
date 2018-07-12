package com.darkhorse.mvvmframe

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import com.darkhorse.baseframe.BaseActivity

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
abstract class BaseMvvmActivity<E, M : BaseModel, VM : BaseViewModel<E, M>, B : ViewDataBinding> : BaseActivity() {

    protected val mViewModel by lazy {
        ViewModelProviders.of(this).get(createViewModel()::class.java)
    }

    protected val mBinding by lazy {
        DataBindingUtil.inflate<B>(layoutInflater, getLayoutId(), null, false)
    }

    protected abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.mLiveData.observe(this, Observer<E> {
            updateData(it)
        })
    }

    override fun getContentView(): View = mBinding.root

    protected abstract fun updateData(bean: E?)

}
