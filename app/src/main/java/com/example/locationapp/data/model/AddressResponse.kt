package com.example.locationapp.data.model

import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("cep")
    val cep: String?,
    @SerializedName("logradouro")
    val rua: String?,
    @SerializedName("bairro")
    val bairro: String?,
    @SerializedName("localidade")
    val cidade: String?,
    @SerializedName("estado")
    val estado: String?,
    @SerializedName("regiao")
    val regiao: String?,
    @SerializedName("ddd")
    val ddd: String?
)