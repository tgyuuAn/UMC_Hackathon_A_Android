package com.pknu.busannollerwar.presentation.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pknu.busannollerwar.presentation.splash.SplashEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor() : ViewModel() {

    private val _eventFlow = MutableSharedFlow<SettingEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    fun navigateToNotice() = event(SettingEvent.NavigateToNotice)

    private fun event(event: SettingEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}