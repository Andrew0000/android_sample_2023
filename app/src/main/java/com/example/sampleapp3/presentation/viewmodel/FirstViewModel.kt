package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp3.data.repository.UserRepository
import com.example.sampleapp3.presentation.navigation.AppScreen
import com.example.sampleapp3.presentation.navigation.NavigationMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class FirstViewModel(
    private val navigationMediator: NavigationMediator,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _subTitle = MutableStateFlow("")
    val subTitle: StateFlow<String> = _subTitle

    init {
        Timber.d("FirstViewModel init")
        viewModelScope.launch {
            loadTitle()
            loadSubTitle()
        }
    }

    fun onClickNextButton() {
        navigationMediator.requestScreen(AppScreen.SECOND)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("FirstViewModel onCleared")
    }

    private suspend fun loadTitle() {
        withContext(Dispatchers.IO) {
            try {
                val user = userRepository.getUser()
                withContext(Dispatchers.Main) {
                    _title.value = user.name + " " + user.surName
                }
            } catch (e: Exception) {
                ensureActive()
                //TODO show error
            }
        }
    }

    //TODO load from repo
    private suspend fun loadSubTitle() {
        delay(2000)
        _subTitle.value = "Sub Title 1"
    }

}
