package com.example.spacexplorer.presentation.screen.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.spacexplorer.domain.usecases.GetLaunchInfoUseCase
import com.example.spacexplorer.presentation.contracts.MainScreenContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenMVIViewModel @Inject constructor(
    private val getLaunchInfoUseCase: GetLaunchInfoUseCase
): BaseViewModel<MainScreenContract.Event, MainScreenContract.State, MainScreenContract.Effect>() {
    override fun setInitialState(): MainScreenContract.State {
        return MainScreenContract.State()    }

    override fun handleEvents(event: MainScreenContract.Event) {
        when (event) {
            is MainScreenContract.Event.LoadLaunches -> loadLaunches()
        }    }

    private fun loadLaunches() {
        viewState.value = viewState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getLaunchInfoUseCase().collect { launches ->
                    setState { copy(launches = launches, isLoading = false) }
                }
            } catch (e: Exception) {
                setState { copy(isLoading = false, error = e.message) }
                setEffect { MainScreenContract.Effect.ShowError(e.message ?: "Unknown error") }
            }
        }
    }
}