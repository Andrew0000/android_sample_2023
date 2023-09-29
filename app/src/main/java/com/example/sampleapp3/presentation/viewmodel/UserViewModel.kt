package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp3.data.repository.UserRepository
import com.example.sampleapp3.presentation.navigation.AppScreen
import com.example.sampleapp3.presentation.navigation.NavigationMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class UserViewModel(
    private val navigationMediator: NavigationMediator,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _subTitle = MutableStateFlow("")
    val subTitle: StateFlow<String> = _subTitle

    init {
        Timber.d("UserViewModel init")
        loadUser()
    }

    fun onClickNextButton() {
        navigationMediator.requestScreen(AppScreen.UNIVERSITIES)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("UserViewModel onCleared")
    }

    private fun loadUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = userRepository.getUser()
                withContext(Dispatchers.Main) {
                    _title.value = user.name.first + " " + user.name.last
                    _subTitle.value = user.email
                }
            } catch (e: Exception) {
                ensureActive()
                Timber.e(e)
                //TODO show error
            }
        }
    }
}
