package com.example.locationapp.domain.usecase

import com.example.locationapp.data.mapper.toDomain
import com.example.locationapp.domain.model.Address
import com.example.locationapp.domain.repository.AddressRepository
import javax.inject.Inject

class GetAddressUseCase @Inject constructor(
    private val repository: AddressRepository
) {
    suspend operator fun invoke(cep:String): Address{
        return repository.getAddress(cep).toDomain()
    }
}