package com.darkhorse.mvvmframe.utils

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.darkhorse.mvvmframe.extension.toast
import com.micropole.baseframe.utils.constant.SystemConstant
import java.util.*

/**
 * Description:
 * Created by DarkHorse on 2018/6/8.
 */
object AppManager : LifecycleObserver {
    private var exitTime = 0L

    var mAppLanguage: String = Locale.getDefault().language
        get() = SharePreferencesUtils.get(SystemConstant.SYSTEM_LANGUAGE, field)
        set(value) {
            SharePreferencesUtils.put(SystemConstant.SYSTEM_LANGUAGE, value)
        }


    private val mActivityStack: Stack<Activity> by lazy {
        Stack<Activity>()
    }

    private lateinit var mApplication: Application

    fun init(application: Application) {
        mApplication = application
    }

    /**
     * 添加Activity
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun addActivity(owner: LifecycleOwner) {
        mActivityStack.push(owner as Activity)
    }

    /**
     * 移除Activity
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun removeActivity(owner: LifecycleOwner) {
        mActivityStack.remove(owner as Activity)
    }

    /**
     * 关闭指定Activity
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
    }

    /**
     * 关闭当前Activity
     */
    fun finish() {
        mActivityStack.pop().finish()
    }

    /**
     * 退出APP并关闭所有Activity
     */
    fun appExit(hint: String, delay: Long) {
        val time = System.currentTimeMillis()
        if (exitTime > time - delay) {
            exitNow()
        } else {
            toast(hint)
            exitTime = time
        }
    }

    /**
     * 直接退出APP
     */
    fun exitNow() {
        for (activity in mActivityStack) {
            finishActivity(activity)
        }
    }

    /**
     * 获取当前Activity
     */
    fun curActivity(): Activity = mActivityStack.peek()

    /**
     *  获取Context
     */
    fun context() = mApplication

    /**
     * 启动Activity
     */
    fun startActivity(activity: Activity, clz: Class<out Activity>, bundle: Bundle? = null, isFinished: Boolean = false) {
        val intent = Intent(activity, clz)
        if (bundle != null) {
            intent.putExtra("data", bundle)
        }
        activity.startActivity(intent)
        if (isFinished) {
            activity.finish()
        }
    }

    /**
     * 启动ActivityForResult
     */
    fun startActivityForResult(activity: Activity, clz: Class<out Activity>, requestCode: Int, bundle: Bundle? = null) {
        val intent = Intent(activity, clz)
        if (bundle != null) {
            intent.putExtra("data", bundle)
        }
        activity.startActivityForResult(intent, requestCode)
    }

    /**
     * 跳转浏览器
     */
    fun startBrowser(activity: Activity, url: String) {
        val intent = Intent()
                .setAction("android.intent.action.VIEW")
                .setData(Uri.parse(url))
        activity.startActivity(intent)
    }

    /**
     * 判断指定SDK版本是否大于当前版本
     */
    fun greaterThanSdkVersion(sdkVersion: Int): Boolean {
        return android.os.Build.VERSION.SDK_INT > sdkVersion
    }

    /**
     * 获取应用版本号
     */
    fun getVersionCode() = mApplication.packageManager.getPackageInfo(mApplication.packageName, 0).longVersionCode

    /**
     * 获取版本号名称
     */
    fun getVersionName() = mApplication.packageManager.getPackageInfo(mApplication.packageName, 0).versionName!!
}
