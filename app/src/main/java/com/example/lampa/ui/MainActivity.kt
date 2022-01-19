package com.example.lampa.ui

import android.os.Bundle
import com.example.lampa.R
import com.example.lampa.base.acivity.BaseActivity
import com.example.lampa.base.viewmodels.ViewModelSet
import com.example.lampa.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun init(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setNavController(): Int {
        return R.id.nav_host_fragment

    }

    override fun buildViewModels(): ViewModelSet {
        return ViewModelSet.Builder().build()
    }
}