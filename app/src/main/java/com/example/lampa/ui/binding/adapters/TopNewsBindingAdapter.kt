package com.example.lampa.ui.binding.adapters

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.lampa.R

object TopNewsBindingAdapter {

    @JvmStatic
    @BindingAdapter("glide_image")
    fun bindingTitleDialog(view: AppCompatImageView, src: String?) {
        if(src.isNullOrEmpty()) {
            view.setImageResource(R.color.black)
        } else {
            println(src)
            Glide.with(view)
                .asDrawable()
                .load(src)
                .centerCrop()
                .placeholder(R.color.black)
                .error(R.color.black)
                .fallback(R.color.black)
                .into(view)
        }
    }
}
