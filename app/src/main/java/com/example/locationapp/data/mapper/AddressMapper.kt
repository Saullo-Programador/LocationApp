package com.example.locationapp.data.mapper

import com.example.locationapp.data.model.AddressResponse
import com.example.locationapp.domain.model.Address

fun AddressResponse.toDomain():Address {
    return Address(
        cep = cep,
        rua = rua,
        bairro = bairro,
        cidade = cidade,
        estado = estado,
        regiao = regiao,
        ddd = ddd
    )
}