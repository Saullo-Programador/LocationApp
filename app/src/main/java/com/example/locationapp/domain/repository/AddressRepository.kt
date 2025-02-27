package com.example.locationapp.domain.repository

import com.example.locationapp.data.model.AddressResponse

interface AddressRepository {
    suspend fun getAddress(cep:String):AddressResponse
}