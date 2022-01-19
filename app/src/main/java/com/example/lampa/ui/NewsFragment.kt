package com.example.lampa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lampa.base.fragment.BaseBindingFragment
import com.example.lampa.base.viewmodels.ViewModelSet
import com.example.lampa.databinding.FragmentNewsBinding

class NewsFragment : BaseBindingFragment<FragmentNewsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsBinding
        get() = FragmentNewsBinding::inflate

    override fun init() {
        Toast.makeText(this.context,"123",Toast.LENGTH_LONG)
    }

    override fun buildViewModels(): ViewModelSet {
        return ViewModelSet.Builder().build()
    }
}