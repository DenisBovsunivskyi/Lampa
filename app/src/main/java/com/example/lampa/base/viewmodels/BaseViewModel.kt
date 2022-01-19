package com.example.lampa.base.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lampa.base.network.BaseResponse

abstract class BaseViewModel : ViewModel() {
    open fun init() {
        clearActionMode()
    }

    protected val actionMode: MutableLiveData<ActionMode> = MutableLiveData()

    fun getActionMode(): LiveData<ActionMode> {
        return actionMode
    }
    fun setAction(action: ActionMode) {
        actionMode.postValue(action)
    }
    private fun clearActionMode() {
        actionMode.value = null
    }
    private val errorMode: MutableLiveData<String> = MutableLiveData()
    fun getErrorMode(): LiveData<String> {
        return errorMode
    }

}
