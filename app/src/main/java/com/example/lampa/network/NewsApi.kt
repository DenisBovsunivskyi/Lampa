package com.example.lampa.network

import com.example.lampa.network.dto.NewsDto
import retrofit2.http.*

interface NewsApi {
    companion object {
        const val API_GET_NEWS = "http://188.40.167.45:3001/"

    }
    @GET(API_GET_NEWS)
    suspend fun getNews():List<NewsDto>



}
