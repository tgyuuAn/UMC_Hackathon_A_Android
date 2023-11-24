package com.pknu.busannollerwar.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _eventFlow = MutableSharedFlow<SplashEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(2000L)
            event(SplashEvent.TimerDone)
        }
    }

    private fun event(event: SplashEvent) = viewModelScope.launch { _eventFlow.emit(event) }

    sealed class SplashEvent {
        data object TimerDone : SplashEvent()
    }
}