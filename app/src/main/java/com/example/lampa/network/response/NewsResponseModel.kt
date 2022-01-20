package com.example.lampa.network.response

import com.example.lampa.network.dto.NewsDto
import com.squareup.moshi.Json
import retrofit2.Response

data class NewsResponseModel(
    val newsDto: List<NewsDto?>? = null
) : BaseResponse()