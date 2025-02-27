package com.example.locationapp.domain.model

import com.example.locationapp.ui.features.states.FormState

data class Address(
    val cep: String? = null,
    val rua: String? = null,
    val bairro: String? = null,
    val cidade: String? = null,
    val estado: String? = null,
    val regiao: String? = null,
    val ddd: String? = null
) {
    fun toFormState(search: String): FormState {
        return FormState(
            search = search,
            cep = cep,
            rua = rua,
            bairro = bairro,
            cidade = cidade,
            estado = estado,
            regiao = regiao,
            ddd = ddd
        )
    }
}