package com.georgimirchev.serversiderenderedviews.kdi

import com.georgimirchev.serversiderenderedviews.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun provideMainModule() = module {
    viewModel { MainViewModel(uiComponentDataRepository = get()) }
}
