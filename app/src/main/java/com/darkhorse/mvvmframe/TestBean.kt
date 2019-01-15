package com.darkhorse.mvvmframe

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestBean(
        var name: String,
        var age: Int
) : Parcelable
