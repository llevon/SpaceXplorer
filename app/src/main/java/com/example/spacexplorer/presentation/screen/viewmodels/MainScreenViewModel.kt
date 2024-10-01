package com.example.spacexplorer.presentation.screen.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexplorer.domain.models.LaunchInfoModel
import com.example.spacexplorer.domain.usecases.GetLaunchInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getLaunchInfoUseCase: GetLaunchInfoUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        getLaunches()
    }

    private fun getLaunches() {
        viewModelScope.launch {
            getLaunchInfoUseCase()
                .flowOn(Dispatchers.IO)
                .onEach { launchList ->
                    _state.update { currentState ->
                        currentState.copy(models = launchList)
                    }
                }
                .launchIn(this)
        }
    }


    data class State(
        val models: List<LaunchInfoModel> = emptyList(),
    )
}