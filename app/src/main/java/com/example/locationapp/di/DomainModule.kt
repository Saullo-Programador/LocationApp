package com.example.locationapp.di

import com.example.locationapp.data.repository.AddressRepositoryImpl
import com.example.locationapp.domain.repository.AddressRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsAddressRepositoryImpl(
        addressRepositoryImpl: AddressRepositoryImpl
    ):AddressRepository

}