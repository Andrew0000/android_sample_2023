package com.example.sampleapp3.presentation.di

import com.example.sampleapp3.presentation.viewmodel.AppViewModelFactory
import com.example.sampleapp3.presentation.viewmodel.FirstViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single { AppViewModelFactory(get()) }
    viewModel { FirstViewModel(get()) }

}
