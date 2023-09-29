package com.example.sampleapp3.presentation.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigationMediator {

    private val _requestedScreen = MutableStateFlow(AppScreen.USER)
    val requestedScreen: StateFlow<AppScreen> = _requestedScreen

    fun requestScreen(screen: AppScreen) {
        _requestedScreen.value = screen
    }
}
