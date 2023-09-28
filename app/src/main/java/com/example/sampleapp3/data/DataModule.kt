package com.example.sampleapp3.data

import com.example.sampleapp3.data.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single { UserRepository() }

}