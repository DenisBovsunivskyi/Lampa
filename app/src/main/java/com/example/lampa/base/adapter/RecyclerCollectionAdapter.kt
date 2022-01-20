package com.example.lampa.base.adapter

import com.example.lampa.base.listeners.OnItemClickListener

interface RecyclerCollectionAdapter<M> {

    // listeners
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<M>?)


    fun clearAndAddAll(data: Collection<M>?)
    fun getItem(position: Int): M
    fun getAll(): Collection<M>?
    fun isEmpty(): Boolean
}