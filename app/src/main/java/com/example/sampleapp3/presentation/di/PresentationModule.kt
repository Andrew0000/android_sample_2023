package com.example.sampleapp3.presentation.di

import com.example.sampleapp3.presentation.navigation.NavigationMediator
import com.example.sampleapp3.presentation.viewmodel.FirstViewModel
import com.example.sampleapp3.presentation.viewmodel.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single { NavigationMediator() }
    viewModel { FirstViewModel(get(), get()) }
    viewModel { SecondViewModel(get(), get()) }

}
