package com.example.sampleapp3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

class UniversitiesViewModel(
    private val navigationMediator: NavigationMediator,
    private val universitiesRepository: UniversitiesRepository,
) : ViewModel() {

    private val _items = MutableStateFlow(listOf<UniversityScreenItem>())
    val items: StateFlow<List<UniversityScreenItem>> = _items

    init {
        Timber.d("UniversitiesViewModel init")
        loadItems()
    }

    fun onClickBack() {
        navigationMediator.requestScreen(AppScreen.USER)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("UniversitiesViewModel onCleared")
    }

    private fun loadItems() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val items = universitiesRepository.getUniversities()
                withContext(Dispatchers.Main) {
                    _items.value = items
                        .map {
                            UniversityScreenItem(
                                name = it.name,
                                description = it.domains?.firstOrNull()?.toString().orEmpty()
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
