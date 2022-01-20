package com.example.lampa.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import java.lang.ref.WeakReference

abstract class BaseBindingRecyclerListAdapter<M, VDB : ViewDataBinding> : BaseRecyclerListAdapter<M, BaseBindingViewHolder<VDB>>() {

    protected abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VDB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<VDB> {
        val inflater = WeakReference(LayoutInflater.from(parent.context)).get()
        val binding = bindingInflater.invoke(requireNotNull(inflater), parent, false)

        return BaseBindingViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<VDB>, position: Int) {
        bindViewHolder(holder, mList[position])
    }

    abstract fun bindViewHolder(holder: BaseBindingViewHolder<VDB>, model: M)
}