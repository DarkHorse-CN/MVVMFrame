package com.darkhorse.mvvmframe.widgets

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darkhorse.mvvmframe.utils.DisplayUtils

class GridLayoutDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val curPos = parent.getChildLayoutPosition(view)
        val layoutManager = parent.layoutManager as GridLayoutManager
        val spanCount = layoutManager.spanCount

        val realSpace = DisplayUtils.dp2px(space)
        val margin = realSpace * (spanCount - 1) / spanCount

        if (curPos % spanCount == 0) {
            outRect.right = margin
        } else if (curPos % spanCount == spanCount - 1) {
            outRect.left = margin
        } else {
            outRect.left = realSpace - margin
            outRect.right = 2 * margin - realSpace
        }

        if (curPos >= spanCount) {
            outRect.top = realSpace
        }
    }
}
