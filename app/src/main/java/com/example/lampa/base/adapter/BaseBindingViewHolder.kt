package com.example.lampa.base.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseBindingViewHolder<VDB : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: VDB? = DataBindingUtil.bind(itemView)
}