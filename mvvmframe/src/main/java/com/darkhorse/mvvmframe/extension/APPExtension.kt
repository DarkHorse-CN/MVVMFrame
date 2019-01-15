package com.darkhorse.mvvmframe.extension

import com.darkhorse.mvvmframe.utils.AppManager

fun getString(stringId: Int): String = AppManager.curActivity().getString(stringId)

fun getStringArray(arrayId: Int): Array<String> = AppManager.curActivity().resources.getStringArray(arrayId)

