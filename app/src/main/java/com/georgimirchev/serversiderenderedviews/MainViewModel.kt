package com.georgimirchev.serversiderenderedviews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgimirchev.network.api.UiApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val uiApi: UiApi): ViewModel() {
    init {
        viewModelScope.launch {
            val results = uiApi.getLayout("home")
            uiComponents.emit(results.toString())
        }
    }

    val uiComponents = MutableStateFlow("")
}
