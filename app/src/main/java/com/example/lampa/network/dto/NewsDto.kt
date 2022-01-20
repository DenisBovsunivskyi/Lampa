package com.example.lampa.network.dto

import com.squareup.moshi.Json

data class NewsDto (
    var title:String?,
    var type:String?,
    var img:String?,
    @Json(name = "click_url") var clickUrl:String,
    var time:String,
)