package com.example.locationapp.data.repository

import com.example.locationapp.data.api.AddressService
import com.example.locationapp.data.model.AddressResponse
import com.example.locationapp.domain.repository.AddressRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressRepositoryImpl @Inject constructor(
    private val addressService: AddressService
): AddressRepository {
    override suspend fun getAddress(cep: String): AddressResponse {
        return addressService.getAddress(cep)
    }
}