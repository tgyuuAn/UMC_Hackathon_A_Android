package com.pknu.busannollerwar.presentation.home

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pknu.busannollerwar.presentation.util.dpToPx

class HomeListDecoration(private val context: Context) : RecyclerView.ItemDecoration() {
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
            outRect.set(0, 20.dpToPx(), 0, 0)
        }
    }
}
