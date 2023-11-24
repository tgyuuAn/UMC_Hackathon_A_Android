package com.pknu.busannollerwar.presentation.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("setGlide")
    fun setGlide(imageView: ImageView, img: String) {
        Glide.with(imageView.context).load(img).into(imageView)
    }
}
