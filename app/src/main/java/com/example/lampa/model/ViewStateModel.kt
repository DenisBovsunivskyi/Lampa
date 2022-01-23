package com.example.lampa.model

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

data class ViewStateModel(
    var selectedEventsTabPosition: Int = TABS_FIRST_SELECTED_POSITION
)
const val TABS_FIRST_SELECTED_POSITION = 0