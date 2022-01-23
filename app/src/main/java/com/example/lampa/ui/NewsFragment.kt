package com.example.lampa.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.Observable
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.lampa.R
import com.example.lampa.base.adapter.addItemClickListener
import com.example.lampa.base.adapter.doOnItemClick
import com.example.lampa.base.fragment.BaseBindingFragment
import com.example.lampa.base.viewmodels.ActionMode
import com.example.lampa.base.viewmodels.ViewModelSet
import com.example.lampa.databinding.FragmentNewsBinding
import com.example.lampa.help.*
import com.example.lampa.model.NewsModel
import com.example.lampa.model.TabFilter
import com.example.lampa.ui.adapter.NewsRecyclerAdapter
import com.example.lampa.ui.adapter.ViewPagerAdapter
import com.example.lampa.viewmodels.NewsViewModel
import com.example.lampa.viewmodels.ViewStateViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class NewsFragment : BaseBindingFragment<FragmentNewsBinding>() {
    private val viewPagerAdapter: ViewPagerAdapter by lazy {
        return@lazy ViewPagerAdapter()

    }
    private val recyclerAdapter: NewsRecyclerAdapter by lazy {
        return@lazy NewsRecyclerAdapter()

    }
    private val newsViewModel by activityViewModels<NewsViewModel>()
    private val stateViewModel by activityViewModels<ViewStateViewModel>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsBinding
        get() = FragmentNewsBinding::inflate

    override fun init() {
        newsViewModel.getNews()
        initTabs()

    }

    private fun initTabs() {
        initDataFromTab()

        binding.tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                initDataFromTab()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                initDataFromTab()
            }
        })
    }

    private fun initDataFromTab() {
        stateViewModel.updateSelectedEventsTab(
            binding.tabLayout.selectedTabPosition
        )

        when (stateViewModel.getSelectedEventsTab()) {
            STORIES_TAB -> {
                recyclerAdapter.clearAndAddAll(
                    newsViewModel.getNewsList()?.filter { it.type == STORIES })
            }
            VIDEO_TAB -> {
                recyclerAdapter.clearAndAddAll(
                    newsViewModel.getNewsList()?.filter { it.type == VIDEO })
            }
            FAVOURITES_TAB -> {
                recyclerAdapter.clearAndAddAll(
                    newsViewModel.getNewsList()?.filter { it.type == FAVOURITES })
            }
        }
    }

    override fun initViews() {
        val itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(resources.getDrawable(R.drawable.divider))
        binding.viewpager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.viewPagerTabs, binding.viewpager) { tab, position ->
        }.attach()
        binding.recycler.adapter = recyclerAdapter
        binding.recycler.addItemDecoration(itemDecoration)

    }

    override fun initViewModels() {
    }

    override fun initListeners() {
        newsViewModel.getNewsLiveData().observe(viewLifecycleOwner) { list ->
            viewPagerAdapter.clearAndAddAll(list.filter { it.top == TOP_FILTER })
            recyclerAdapter.clearAndAddAll(list.filter { it.type == STORIES })
        }
        newsViewModel.query.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (newsViewModel.query.get().isNullOrEmpty()) {
                    initDataFromTab()
                } else {
                    recyclerAdapter.clearAndAddAll(newsViewModel.getNewsList()?.filter {
                        newsViewModel.query.get()?.let { query ->
                            it.title?.lowercase()?.contains(query.lowercase())
                        } == true
                    })
                }
            }
        })
        recyclerAdapter.doOnItemClick {
            onWebIntent(handleClickUrl(it))
        }
        viewPagerAdapter.doOnItemClick {
            onWebIntent(handleClickUrl(it))
        }
    }


    private fun onWebIntent(url:String?){
        val webIntent: Intent = Uri.parse(url).let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        startActivity(webIntent)
    }

    override fun buildViewModels(): ViewModelSet {
        return ViewModelSet.Builder()
            .addViewModel(newsViewModel)
            .addViewModel(stateViewModel)
            .build()
    }

}