package com.pknu.busannollerwar.presentation.thingstodo

import com.pknu.busannollerwar.data.model.Article

sealed class ThingsToDoEvent {
    data class NavigateToArticleDetail(val article : Article) : ThingsToDoEvent()
}