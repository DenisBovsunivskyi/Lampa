package com.example.lampa.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.lampa.mapper.mapFromDto
import com.example.lampa.model.NewsModel
import com.example.lampa.network.NewsApi
import com.example.lampa.network.dto.NewsDto
import com.example.lampa.repository.NewsRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val STARTING_PAGE_INDEX = 1

class NewsPagerSource(
    private val newsApi: NewsApi,
) : PagingSource<Int, NewsModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsModel> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = newsApi.getNews(position)
            val news = mapFromDto(response.body())
            LoadResult.Page(
                data = news,
                prevKey = null,
                nextKey = if (news.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}