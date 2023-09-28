package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.sampleapp3.data.repository.UserRepository

class AppViewModelFactory(
    private val userRepository: UserRepository,
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
        when {
            modelClass.isAssignableFrom(FirstViewModel::class.java) ->
                FirstViewModel(userRepository)

            else ->
                throw IllegalArgumentException("Unknown View Model")

        } as T
}
