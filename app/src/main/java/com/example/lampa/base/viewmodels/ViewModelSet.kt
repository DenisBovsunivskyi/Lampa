package com.example.lampa.base.viewmodels

class ViewModelSet (
    val viewModels: Set<BaseViewModel>,
) {

    data class Builder(
        private val _viewModels: MutableSet<BaseViewModel> = mutableSetOf(),
    ) {
        fun addViewModel(viewModel: BaseViewModel) = apply {
            _viewModels.add(viewModel)
        }

        fun build(): ViewModelSet {
            return ViewModelSet(_viewModels)
        }
    }
}
