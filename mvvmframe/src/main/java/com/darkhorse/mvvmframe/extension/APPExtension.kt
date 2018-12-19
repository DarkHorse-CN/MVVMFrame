package com.darkhorse.mvvmframe.extension

import android.content.Context

fun Context.getString(stringId: Int): String = this.getString(stringId)

fun Context.getStringArray(arrayId: Int): Array<String> = this.resources.getStringArray(arrayId)
