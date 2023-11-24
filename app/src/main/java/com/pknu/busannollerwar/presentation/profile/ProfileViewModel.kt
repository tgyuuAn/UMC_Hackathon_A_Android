package com.pknu.busannollerwar.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pknu.busannollerwar.presentation.setting.SettingEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ProfileEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    private fun event(event: ProfileEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}