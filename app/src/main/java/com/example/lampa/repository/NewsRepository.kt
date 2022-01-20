package com.example.lampa.repository

import androidx.databinding.ObservableField
import com.example.lampa.network.NewsApi
import com.example.lampa.network.response.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api:NewsApi,
) {


    suspend fun getNews() =
        flow {
            emit(api.getNews())
        }.flowOn(Dispatchers.IO)
}