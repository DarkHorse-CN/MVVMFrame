package com.darkhorse.mvvmframe.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {

    fun timeStamp2Date(timeStamp: Long, format: String): String {
        return SimpleDateFormat(format).format(Date(timeStamp))
    }

    fun timeInMillis() = Calendar.getInstance().timeInMillis

}
