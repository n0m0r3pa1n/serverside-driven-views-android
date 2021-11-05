package com.georgimirchev.serversiderenderedviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.georgimirchev.serversiderenderedviews.stateflow.observeInLifecycle
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel
            .uiComponents
            .onEach { Timber.d("### $it") }
            .observeInLifecycle(this)
    }
}
