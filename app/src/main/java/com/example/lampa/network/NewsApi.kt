package com.example.lampa.network

import com.example.lampa.network.response.NetworkResponse
import com.example.lampa.network.response.NewsResponseModel
import retrofit2.http.*

interface NewsApi {
    companion object {
        const val API_GET_NEWS = "http://188.40.167.45:3001/"

    }
    @GET(API_GET_NEWS)
    @FormUrlEncoded
    suspend fun getNews(): NetworkResponse<NewsResponseModel>



}
