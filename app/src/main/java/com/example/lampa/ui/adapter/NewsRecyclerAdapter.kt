package com.example.lampa.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lampa.base.adapter.BaseBindingRecyclerListAdapter
import com.example.lampa.base.adapter.BaseBindingViewHolder
import com.example.lampa.databinding.ItemNewsBinding
import com.example.lampa.databinding.ItemTopNewsBinding
import com.example.lampa.model.NewsModel

class NewsRecyclerAdapter : BaseBindingRecyclerListAdapter<NewsModel, ItemNewsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemNewsBinding
        get() = ItemNewsBinding::inflate


    override fun bindViewHolder(
        holder: BaseBindingViewHolder<ItemNewsBinding>,
        model: NewsModel
    ) {
        println(model.img)
        holder.binding?.model = model
        holder.binding?.root?.setOnClickListener {
            mOnItemClickListener?.onItemClick(model)
        }
    }
}