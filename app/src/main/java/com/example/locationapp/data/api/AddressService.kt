package com.example.locationapp.data.api

import com.example.locationapp.data.model.AddressResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {
    @GET("{cep}/json")
    suspend fun getAddress(
        @Path("cep") cep: String
    ):AddressResponse

}