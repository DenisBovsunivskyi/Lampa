package com.example.lampa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.lampa.base.fragment.BaseBindingFragment
import com.example.lampa.base.viewmodels.ViewModelSet
import com.example.lampa.databinding.FragmentNewsBinding
import com.example.lampa.model.NewsModel
import com.example.lampa.ui.adapter.ViewPagerAdapter
import com.example.lampa.viewmodels.NewsViewModel
import com.google.android.material.tabs.TabLayoutMediator

class NewsFragment : BaseBindingFragment<FragmentNewsBinding>() {
    private val viewPagerAdapter: ViewPagerAdapter by lazy {
        return@lazy ViewPagerAdapter()
    }
    private val newsViewModel by activityViewModels<NewsViewModel>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsBinding
        get() = FragmentNewsBinding::inflate

    override fun init() {
        println("initMain")
    }

    override fun initViews() {
        binding.viewpager.adapter = viewPagerAdapter
        viewPagerAdapter.clearAndAddAll(
            listOf<NewsModel>(
                NewsModel(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "favorites",
                    "http://188.40.167.45:3001/img/test3.jpg",
                    "123",
                    "2 ours ego"
                ),
                NewsModel(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "favorites",
                    "http://188.40.167.45:3001/img/test4.jpg",
                    "123",
                    "2 ours ego"
                )
            )
        )
        TabLayoutMediator(binding.viewPagerTabs, binding.viewpager) { tab, position ->
        }.attach()

    }

    override fun initViewModels() {
        println("init")
        newsViewModel.getNews()
    }

    override fun buildViewModels(): ViewModelSet {
        return ViewModelSet.Builder()
            .addViewModel(newsViewModel)
            .build()
    }
}