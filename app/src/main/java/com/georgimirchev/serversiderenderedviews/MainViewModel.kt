package com.georgimirchev.serversiderenderedviews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgimirchev.domain.repository.UiComponentDataRepository
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MainViewModel(private val uiComponentDataRepository: UiComponentDataRepository): ViewModel() {
    init {
        viewModelScope.launch {
            val results = uiComponentDataRepository.getUiComponentsData()
            uiComponentsData.emit(results.toString())
        }
    }

    val uiComponentsData = MutableSharedFlow<String>(replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST)
}
