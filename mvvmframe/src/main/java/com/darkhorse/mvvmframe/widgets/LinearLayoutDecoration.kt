package com.micropole.baseframe.widgets

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.darkhorse.mvvmframe.utils.DisplayUtils

class LinearLayoutDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val curPos = parent.getChildLayoutPosition(view)
        if (curPos == 0) {
            outRect.top = 0
        } else {
            outRect.top = DisplayUtils.dp2px(space)
        }
    }
}
