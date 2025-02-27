package com.example.locationapp.ui.features.actions

sealed class FormAction {
    data object SearchAddress : FormAction()
    data class UpdateSearch(val search: String) : FormAction()
}