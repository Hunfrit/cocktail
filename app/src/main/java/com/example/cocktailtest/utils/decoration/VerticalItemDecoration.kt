package com.example.cocktailtest.utils.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cocktailtest.R
import com.example.cocktailtest.extensions.getDimens

class VerticalItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        parent.let {
            if (it.getChildAdapterPosition(view) == 0) {
                outRect.top = getDimens(R.dimen.layout_margin)
            }
        }
        outRect.bottom = getDimens(R.dimen.half_layout_margin)
    }
}