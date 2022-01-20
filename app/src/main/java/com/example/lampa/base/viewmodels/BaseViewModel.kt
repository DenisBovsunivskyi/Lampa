package com.example.lampa.base.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lampa.network.response.BaseResponse
import com.example.lampa.network.response.NetworkResponse

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
    protected fun <K : BaseResponse> handleResponse(
        response: NetworkResponse<K>
    ): K? {
        return return when (response) {
            is NetworkResponse.Success.Result -> response.body
            is NetworkResponse.Success.Empty -> null
        }
    }

}
