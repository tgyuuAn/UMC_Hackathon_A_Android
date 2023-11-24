package com.pknu.busannollerwar.presentation.languageselection

sealed class LanguageSelectionEvent {
    data object NavigateToHome : LanguageSelectionEvent()
}