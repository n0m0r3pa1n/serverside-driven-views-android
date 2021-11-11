package com.georgimirchev.serversiderenderedviews

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.georgimirchev.serversiderenderedviews.stateflow.observeInLifecycle
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    // Reminder: Can use a ViewModel for the whole navgraph
    // val mainViewModel: NavViewModel by koinNavGraphViewModel(R.id.my_graph)

    private val serverDrivenComponentsAdapter: ServerDrivenComponentsAdapter by inject()
    private val mainViewModel: MainViewModel by viewModel()
    private val componentsRecyclerView: RecyclerView by lazy { findViewById(R.id.rv_components) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        componentsRecyclerView.adapter = serverDrivenComponentsAdapter
        componentsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainViewModel
            .uiComponentsData
            .onEach {
                serverDrivenComponentsAdapter.setItems(it)
                // Should we handle here Compose views that have their own ViewModel
                // And each ViewModel loads data by using the DisposableEffect from here
                // https://medium.com/nerd-for-tech/handling-lifecycle-events-on-jetpack-compose-f4f53de41f0a
            }
            .observeInLifecycle(this)

        serverDrivenComponentsAdapter.uiEvents
            .onEach { Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show() }
            .observeInLifecycle(this)
    }
}
