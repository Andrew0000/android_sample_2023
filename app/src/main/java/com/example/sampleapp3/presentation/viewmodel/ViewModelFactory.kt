package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.sampleapp3.data.repository.UserRepository

class ViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
        when {
            //TODO
            modelClass.isAssignableFrom(FirstViewModel::class.java) -> {
                FirstViewModel(UserRepository()) as T
            }
            else -> throw IllegalArgumentException("Unknown View Model")
        }
}
