package com.darkhorse.mvvmframe.http.minterface

/**
 * Description:
 * Created by DarkHorse on 2018/7/23.
 */
interface ISingleToken {
    fun getTokenKey(): String

    fun getToken(): String
}