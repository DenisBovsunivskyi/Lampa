package com.example.lampa.repository

import androidx.databinding.ObservableField
import com.example.lampa.network.NewsApi
import com.example.lampa.network.dto.NewsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api:NewsApi,
) {
    suspend fun getNews():List<NewsDto> {
       return api.getNews()
    }    }