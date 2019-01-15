package com.darkhorse.mvvmframe.utils

import com.darkhorse.mvvmframe.utils.AppManager
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

object AssertUtils {

    fun readFile(fileName: String): String {
        val stringBuilder = StringBuilder()
        val inputStream = AppManager.context().assets.open(fileName)
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        var line: String?
        line = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line)
            line = bufferedReader.readLine()
        }
        return stringBuilder.toString()
    }
}

