package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp3.data.model.University
import com.example.sampleapp3.data.repository.UniversitiesRepository
import com.example.sampleapp3.presentation.navigation.AppScreen
import com.example.sampleapp3.presentation.navigation.NavigationMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class SecondViewModel(
    private val navigationMediator: NavigationMediator,
    private val universitiesRepository: UniversitiesRepository,
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

    private fun loadItems() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val items = universitiesRepository.getUniversities()
                withContext(Dispatchers.Main) {
                    _items.value = items
                        .map {
                            SecondScreenItem(
                                it.name,
                                it.domains?.firstOrNull()?.toString().orEmpty()
                            )
                        }
                }
            } catch (e: Exception) {
                ensureActive()
                Timber.e(e)
                //TODO show error
            }
        }
    }

}
