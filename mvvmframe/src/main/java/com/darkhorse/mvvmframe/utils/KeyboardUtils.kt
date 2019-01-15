package com.darkhorse.mvvmframe.utils

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

object KeyboardUtils {
    fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }

    fun isHideInput(view: View, ev: MotionEvent): Boolean {
        if (view is EditText) {
            val l = intArrayOf(0, 0)
            view.getLocationInWindow(l)
            val left = l[0]
            val top = l[1]
            val bottom = top + view.height
            val right = left + view.width

            return !(ev.x > left && ev.x < right && ev.y > top && ev.y < bottom)
        }
        return false
    }
}
