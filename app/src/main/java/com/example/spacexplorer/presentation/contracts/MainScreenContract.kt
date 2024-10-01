package com.example.spacexplorer.presentation.contracts

import com.example.spacexplorer.domain.models.LaunchInfoModel
import com.example.spacexplorer.presentation.screen.viewmodels.ViewEffect
import com.example.spacexplorer.presentation.screen.viewmodels.ViewEvent
import com.example.spacexplorer.presentation.screen.viewmodels.ViewState

class MainScreenContract {
    sealed class Event : ViewEvent {
        object LoadLaunches : Event()
    }

    data class State(
        val launches: List<LaunchInfoModel> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null
    ) : ViewState

    sealed class Effect : ViewEffect {
        data class ShowError(val message: String) : Effect()
    }
}