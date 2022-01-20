package com.example.lampa.base.listeners

import android.view.View

interface OnItemClickListener<M> {
    fun onItemClick(item: M)
    fun onItemClick(view: View?)
    fun onItemClick(item: M, view: View?)
}