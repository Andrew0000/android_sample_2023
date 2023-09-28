package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.sampleapp3.data.repository.UserRepository

class AppViewModelFactory: ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
        when {
            //TODO DI
            modelClass.isAssignableFrom(FirstViewModel::class.java) -> {
                FirstViewModel(UserRepository())
            }
            else -> throw IllegalArgumentException("Unknown View Model")
        } as T
}
