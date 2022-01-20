package com.example.lampa.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lampa.base.viewmodels.BaseViewModel
import com.example.lampa.model.NewsModel
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


     fun getNews() {
        viewModelScope.launch {
         val news =newsRepository.getNews()
            println(news)

        }

    }

}
