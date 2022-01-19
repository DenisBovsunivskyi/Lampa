package com.example.lampa.ui

import android.os.Bundle
import android.view.Menu
import androidx.drawerlayout.widget.DrawerLayout
import com.example.lampa.R
import com.example.lampa.base.acivity.BaseActivity
import com.example.lampa.base.viewmodels.ViewModelSet
import com.example.lampa.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.content.res.AppCompatResources


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun init(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initToolbar()
    }
    private fun initToolbar(){
        val toolbar= findViewById<View>(R.id.toolbar) as androidx.appcompat.widget.Toolbar
        toolbar.navigationIcon = AppCompatResources.getDrawable(this.applicationContext,R.drawable.ic_menu_left)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.text_news)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun setNavController(): Int {
        return R.id.nav_host_fragment

    }


    override fun buildViewModels(): ViewModelSet {
        return ViewModelSet.Builder().build()
    }
}