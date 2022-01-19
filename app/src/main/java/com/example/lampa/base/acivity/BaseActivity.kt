package com.example.lampa.base.acivity

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lampa.base.viewmodels.ActionMode
import com.example.lampa.base.viewmodels.ViewModelSet

abstract class BaseActivity : AppCompatActivity(), NavigationActivity {
    protected lateinit var mNavController: NavController
    protected lateinit var mNavHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavController()
        init(savedInstanceState)
        initViews()
        initViewModels()
        initListeners()
        setObserveToBaseViewModels()

    }

    abstract fun init(savedInstanceState: Bundle?)

    protected open fun initViews() {}
    protected open fun initViewModels() {}
    protected open fun initListeners() {}
    abstract fun setNavController(): Int


    override fun initNavController() {
        @IdRes val resIdNavHostFragment = setNavController()

        if (supportFragmentManager.findFragmentById(resIdNavHostFragment) is NavHostFragment) {
            mNavHostFragment =
                supportFragmentManager.findFragmentById(resIdNavHostFragment) as NavHostFragment
            mNavController = mNavHostFragment.navController
            onInitNavController()

        }
    }

    /**
     * called when initialization of nav controller was successful
     * you can do anything with NavController and don't get any exceptions
     */
    open fun onInitNavController() {
        // empty
    }

    //  this method need override for building viewModels dependencies
    protected abstract fun buildViewModels(): ViewModelSet

    private fun setObserveToBaseViewModels() {
        val set = buildViewModels()

        set.viewModels.forEach { baseViewModel ->
            baseViewModel.init()
            baseViewModel.getActionMode().observe(this, { handleActionMode(it) })
        }

    }
    protected fun handleFailure(failureMsg: String?) {
//        showFailure(failureMsg)
    }
    // Override method if you want catch any action from viewModels
    protected open fun handleActionMode(mode: ActionMode?) {

    }

}
