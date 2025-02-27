package com.example.locationapp.di

import com.example.locationapp.data.api.AddressService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providesAddressService(
        retrofit: Retrofit
    ): AddressService {
        return retrofit.create(AddressService::class.java)
    }
}