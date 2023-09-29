package com.example.sampleapp3.presentation.di

import com.example.sampleapp3.presentation.navigation.NavigationMediator
import com.example.sampleapp3.presentation.viewmodel.UserViewModel
import com.example.sampleapp3.presentation.viewmodel.UniversitiesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single { NavigationMediator() }
    viewModel { UserViewModel(get(), get()) }
    viewModel { UniversitiesViewModel(get(), get()) }

}
