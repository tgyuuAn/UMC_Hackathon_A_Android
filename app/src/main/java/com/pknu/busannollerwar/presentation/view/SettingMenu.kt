package com.pknu.busannollerwar.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.pknu.busannollerwar.R

class SettingMenu @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var title: TextView

    init {
        val infService = Context.LAYOUT_INFLATER_SERVICE
        val li = context.getSystemService(infService) as LayoutInflater
        val view = li.inflate(R.layout.view_bar, this, false)
        addView(view)

        title = findViewById<TextView>(R.id.barTitleTV)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingMenu)
        val titleText = typedArray.getString(R.styleable.SettingMenu_title) ?: ""

        title.text = titleText

        typedArray.recycle()
    }
}