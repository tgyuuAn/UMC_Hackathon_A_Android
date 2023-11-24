package com.pknu.busannollerwar.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("user_id") val userID : String,
    @SerialName("nickname") val nickNmae : String
)
