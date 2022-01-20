package com.example.lampa.base.adapter

import android.view.View
import com.example.lampa.base.listeners.OnItemClickListener

inline fun <M> RecyclerCollectionAdapter<M>.doOnItemClick(crossinline action: (item: M) -> Unit) =
    addItemClickListener(onItemClick = action)

inline fun <M> RecyclerCollectionAdapter<M>.addItemClickListener(
    crossinline onItemViewClick: (item: M, view: View?) -> Unit = { _, _ -> },
    crossinline onViewClick: (view: View?) -> Unit = { _ -> },
    crossinline onItemClick: (item: M) -> Unit = {},
): OnItemClickListener<M> {

    val listener = object : OnItemClickListener<M> {
        override fun onItemClick(item: M) {
            onItemClick.invoke(item)
        }

        override fun onItemClick(view: View?) {
            onViewClick.invoke(view)
        }

        override fun onItemClick(item: M, view: View?) {
            onItemViewClick.invoke(item, view)
        }
    }

    setOnItemClickListener(listener)

    return listener
}