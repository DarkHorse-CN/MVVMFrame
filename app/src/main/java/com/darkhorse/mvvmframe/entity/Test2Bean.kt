package com.darkhorse.mvvmframe.entity

import com.google.gson.annotations.SerializedName

/**
 * Description:
 * Created by DarkHorse on 2018/7/12.
 */
class Test2Bean(
        @SerializedName("title") val title: String,
        @SerializedName("content") val content: String
)
