package com.example.lampa.base.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.lampa.base.listeners.OnItemClickListener
import java.util.*

abstract class BaseRecyclerListAdapter<M, VH : RecyclerView.ViewHolder>() : RecyclerView.Adapter<VH>(), RecyclerCollectionAdapter<M> {

    protected var mList: MutableList<M> = mutableListOf()
    protected var mOnItemClickListener: OnItemClickListener<M>? = null


    init {
        mList = mutableListOf()
    }

    constructor(list: List<M>): this() {
        mList.addAll(list)
    }

    override fun clearAndAddAll(data: Collection<M>?) {
        data?.let {
            mList.clear()
            for (item in data) {
                addInternal(item)
            }
            notifyDataSetChanged()
        }
    }
    override fun isEmpty(): Boolean {
        return mList.isEmpty()
    }

    override fun getItem(position: Int): M {
        return mList[position]
    }

    override fun getAll(): Collection<M>? {
        return mList
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    private fun addInternal(item: M) {
        mList.add(item)
    }

    private fun addInternal(position: Int, item: M) {
        mList.add(position, item)
    }
    override fun setOnItemClickListener(onItemClickListener: OnItemClickListener<M>?) {
        mOnItemClickListener = onItemClickListener
    }
}