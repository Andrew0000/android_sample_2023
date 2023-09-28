package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp3.data.repository.UserRepository
import com.example.sampleapp3.presentation.navigation.AppScreen
import com.example.sampleapp3.presentation.navigation.NavigationMediator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class SecondViewModel(
    private val navigationMediator: NavigationMediator,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _items = MutableStateFlow(listOf<SecondScreenItem>())
    val items: StateFlow<List<SecondScreenItem>> = _items

    init {
        Timber.d("SecondViewModel init")
        loadItems()
    }

    fun onClickBack() {
        navigationMediator.requestScreen(AppScreen.FIRST)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("SecondViewModel onCleared")
    }

    //TODO load from repo
    private fun loadItems() {
        viewModelScope.launch {
            delay(2000)
            _items.value = listOf(
                SecondScreenItem("first", "this is first"),
                SecondScreenItem("second", "this is second"),
                SecondScreenItem("third", "this is third"),
            )
        }
    }

}
