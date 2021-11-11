package com.georgimirchev.serversiderenderedviews.kdi

import com.georgimirchev.serversiderenderedviews.MainViewModel
import com.georgimirchev.serversiderenderedviews.ServerDrivenComponentsAdapter
import com.georgimirchev.serversiderenderedviews.viewholders.ViewHolderMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun provideMainModule() = module {
    viewModel { MainViewModel(uiComponentDataRepository = get()) }

    factory { ViewHolderMapper() }
    factory { ServerDrivenComponentsAdapter(viewHolderMapper = get()) }
}
