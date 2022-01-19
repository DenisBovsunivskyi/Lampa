package com.example.lampa.base.viewmodels

sealed class ActionMode {
    sealed class Navigate : ActionMode() {
    }
    sealed class Action : ActionMode() {

    }
}
