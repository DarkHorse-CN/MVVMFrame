package com.darkhorse.mvvmframe.extension

import android.util.Log
import android.widget.Toast
import com.darkhorse.mvvmframe.utils.AppManager


fun toast(msg: Any, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(AppManager.currentActivity(), msg.toString(), duration).show()
}

fun d(msg: Any) {
    Log.d(AppManager.context().javaClass.name, msg.toString())
}

fun e(msg: Any) {
    Log.e(AppManager.context().javaClass.name, msg.toString())
}

fun i(msg: Any) {
    Log.i(AppManager.context().javaClass.name, msg.toString())
}

fun v(msg: Any) {
    Log.v(AppManager.context().javaClass.name, msg.toString())
}

fun w(msg: Any) {
    Log.w(AppManager.context().javaClass.name, msg.toString())
}



