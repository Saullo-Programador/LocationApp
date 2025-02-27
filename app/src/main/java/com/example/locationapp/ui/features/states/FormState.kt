package com.example.locationapp.ui.features.states

data class FormState(
    val isLoading:Boolean = false,
    val erro:Boolean = false,
    val search: String = "",
    val cep: String? = null,
    val rua: String? = null,
    val bairro: String? = null,
    val cidade: String? = null,
    val estado: String? = null,
    val regiao: String? = null,
    val ddd: String? = null
)