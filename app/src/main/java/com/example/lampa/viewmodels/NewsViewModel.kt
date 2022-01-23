package com.example.lampa.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lampa.base.viewmodels.ActionMode
import com.example.lampa.base.viewmodels.BaseViewModel
import com.example.lampa.mapper.mapFromDto
import com.example.lampa.model.NewsModel
import com.example.lampa.model.TabFilter
import com.example.lampa.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
) : BaseViewModel() {
    private val page: ObservableField<Int> = ObservableField(1)
    val query:ObservableField<String?> = ObservableField("")
    private val _newsLiveData: MutableLiveData<List<NewsModel>> = MutableLiveData()
    private val tempList:MutableList<NewsModel> = mutableListOf()


    fun getNewsLiveData(): LiveData<List<NewsModel>> {
        return _newsLiveData
    }

    fun getNewsList():List<NewsModel>?{
        return _newsLiveData.value
    }

    fun getNews() {
        viewModelScope.launch {
            val news = newsRepository.getNews(page.get())
            if (news.body()?.isNotEmpty() == true) {
                tempList.addAll(mapFromDto(news.body()))
                page.set(page.get()?.plus(1))
                getNews()
            } else {
                _newsLiveData.postValue(tempList)
            }
        }

    }

}
