package com.example.sampleapp3.data.di

import com.example.sampleapp3.data.network.Api
import com.example.sampleapp3.data.repository.UniversitiesRepository
import com.example.sampleapp3.data.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single { Api() }
    single { UserRepository(get()) }
    single { UniversitiesRepository(get()) }

}
