package com.example.lampa.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.example.lampa.R
import com.example.lampa.base.acivity.BaseActivity
import com.example.lampa.base.viewmodels.ViewModelSet
import com.example.lampa.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import android.view.View
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import com.example.lampa.viewmodels.NewsViewModel


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val newsViewModel by viewModels<NewsViewModel>()

    override fun init(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initToolbar()
    }

    private fun initToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as androidx.appcompat.widget.Toolbar
        toolbar.navigationIcon =
            AppCompatResources.getDrawable(this.applicationContext, R.drawable.ic_menu_left)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.text_news)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String?): Boolean {
                newsViewModel.query.set(text)
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                if(text.isNullOrEmpty()){
                    newsViewModel.query.set("")
                }
                return true
            }
        })
        return true
    }

    override fun setNavController(): Int {
        return R.id.nav_host_fragment

    }


    override fun buildViewModels(): ViewModelSet {
        return ViewModelSet.Builder()
            .addViewModel(newsViewModel)
            .build()
    }
}