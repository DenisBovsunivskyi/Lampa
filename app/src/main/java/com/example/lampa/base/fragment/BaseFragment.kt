package com.example.lampa.base.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lampa.base.viewmodels.ActionMode
import com.example.lampa.base.viewmodels.ViewModelSet

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        initViews()
        initViewModels()
        initListeners()
        setObserveToBaseViewModels()
    }

    abstract fun init()

    protected open fun initViews() {}
    protected open fun initViewModels() {}
    protected open fun initListeners() {}

    //  this method need override for building viewModels dependencies
    protected abstract fun buildViewModels(): ViewModelSet

    private fun setObserveToBaseViewModels() {
        val set = buildViewModels()

        set.viewModels.forEach { baseViewModel ->
            baseViewModel.init()
            baseViewModel.getActionMode().observe(viewLifecycleOwner, { handleActionMode(it) })
        }

    }


    // Override method if you want catch any action from viewModels
    protected open fun handleActionMode(mode: ActionMode?) {

    }
}
