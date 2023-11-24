package com.pknu.busannollerwar.presentation.thingstodo.articleDetail

import com.pknu.busannollerwar.data.model.Article

sealed class ArticleDetailEvent {
    data class NavigateToReview(val article: Article) : ArticleDetailEvent()
}
