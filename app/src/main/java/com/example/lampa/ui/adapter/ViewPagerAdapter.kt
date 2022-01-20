package com.example.lampa.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lampa.base.adapter.BaseBindingRecyclerListAdapter
import com.example.lampa.base.adapter.BaseBindingViewHolder
import com.example.lampa.databinding.ItemTopNewsBinding
import com.example.lampa.model.NewsModel

class ViewPagerAdapter : BaseBindingRecyclerListAdapter<NewsModel, ItemTopNewsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemTopNewsBinding
        get() = ItemTopNewsBinding::inflate


    override fun bindViewHolder(
        holder: BaseBindingViewHolder<ItemTopNewsBinding>,
        model: NewsModel
    ) {
        holder.binding?.model = model
        holder.binding?.root?.setOnClickListener {
            mOnItemClickListener?.onItemClick(model)
        }
    }
}