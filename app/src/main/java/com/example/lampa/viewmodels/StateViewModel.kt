package com.example.lampa.viewmodels

import androidx.lifecycle.ViewModel
import com.example.lampa.base.viewmodels.BaseViewModel
import com.example.lampa.model.ViewStateModel

class ViewStateViewModel : BaseViewModel() {
    val model: ViewStateModel = ViewStateModel()


    fun updateSelectedEventsTab(position: Int) {
        model.selectedEventsTabPosition = position
    }

    fun getSelectedEventsTab(): Int {
        return model.selectedEventsTabPosition
    }
}
