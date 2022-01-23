package com.example.lampa.ui.binding.adapters

import android.text.SpannableStringBuilder
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.color
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.lampa.R

object TopNewsBindingAdapter {

    @JvmStatic
    @BindingAdapter("glide_top_image")
    fun bindingNewsTopImage(view: AppCompatImageView, src: String?) {
        if (src.isNullOrEmpty()) {
            view.setImageResource(R.color.black)
        } else {
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

    @JvmStatic
    @BindingAdapter("glide_image")
    fun bindingNewsImage(view: AppCompatImageView, src: String?) {
        if (src.isNullOrEmpty()) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
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

    @JvmStatic
    @BindingAdapter("url", "click_url", "time")
    fun bindingClickEndTime(
        view: AppCompatTextView,
        url: String?,
        clickUrl: String?,
        time: String?
    ) {
        if (url.isNullOrEmpty()) {
            view.text = coloredEndText(clickUrl, time, view, false)
        } else {
            view.text = coloredEndText(url, time, view, false)
        }
    }

    @JvmStatic
    @BindingAdapter("url_black", "click_url", "time")
    fun bindingClickEndTimeBlack(
        view: AppCompatTextView,
        url: String?,
        clickUrl: String?,
        time: String?
    ) {
        if (url.isNullOrEmpty()) {
            view.text = coloredEndText(clickUrl, time, view, true)
        } else {
            view.text = coloredEndText(url, time, view, true)
        }
    }

    private fun coloredEndText(
        startText: String?,
        endText: String?,
        view: AppCompatTextView,
        isBlack: Boolean
    ): CharSequence {
        return SpannableStringBuilder()
            .color(view.resources.getColor(R.color.blue_color)) { append(startText) }
            .append(" - ")
            .color(
                if (!isBlack) {
                    view.resources.getColor(R.color.white)
                } else view.resources.getColor(R.color.black)
            ) { append(endText) }
    }
}
