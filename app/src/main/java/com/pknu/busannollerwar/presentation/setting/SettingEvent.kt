package com.pknu.busannollerwar.presentation.setting

sealed class SettingEvent {
    data object NavigateToNotice : SettingEvent()
    data object NavigateToLanguageSetting : SettingEvent()
    data object Logout : SettingEvent()
    data object Withdrawal : SettingEvent()
}