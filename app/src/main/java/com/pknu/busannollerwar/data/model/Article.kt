package com.pknu.busannollerwar.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    @SerialName("board_id") val boardID: Int = 0,
    val title: String = "해운대",
    val content: String = "짱 좋아요",
    @SerialName("created_at") val createdAt: String = "",
    @SerialName("modified_at") val modifiedAt: String = "",
    val hits: Int = 0,
) : java.io.Serializable