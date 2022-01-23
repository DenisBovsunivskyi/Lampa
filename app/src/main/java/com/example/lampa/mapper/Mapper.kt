package com.example.lampa.mapper

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.lampa.model.NewsModel
import com.example.lampa.network.dto.NewsDto

fun mapFromDto(dto: List<NewsDto>?):MutableList<NewsModel> {
    val list:MutableList<NewsModel> = mutableListOf()
    dto?.let { presentDto ->
        for (item in presentDto) {
            list.add(
                NewsModel(
                    item.title,
                    item.type,
                    item.img,
                    item.clickUrl,
                    item.time,
                    item.top,
                    item.url
                )
            )
        }
    }
    return list
}

