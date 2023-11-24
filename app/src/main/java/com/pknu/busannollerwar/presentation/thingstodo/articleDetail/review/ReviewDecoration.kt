package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pknu.busannollerwar.presentation.util.dpToPx

class ReviewDecoration(private val context: Context) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val index = parent.getChildAdapterPosition(view)

        if (index != 0) {
            //좌,상,우,하
            outRect.set(15.dpToPx(), 0, 0, 0)
        }
    }
}
