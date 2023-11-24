package com.pknu.busannollerwar.presentation.languageselection

sealed class LanguageSelectionEvent {
    data object NavigateToHome : LanguageSelectionEvent()
    data class SetLanguage(val language: Language) : LanguageSelectionEvent()
}