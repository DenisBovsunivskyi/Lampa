package com.example.lampa.repository

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.lampa.model.NewsModel
import com.example.lampa.network.NewsApi
import com.example.lampa.network.dto.NewsDto
import com.example.lampa.pager.NewsPagerSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsApi,
) {
    suspend fun getNews(page: Int?): Response<List<NewsDto>> {
        return api.getNews(page)
    }

    fun getSearchResults() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { NewsPagerSource(api) }
        ).liveData
}