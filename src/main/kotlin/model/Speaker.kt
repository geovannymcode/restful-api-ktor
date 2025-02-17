package com.geovannycode.model

import kotlinx.serialization.Serializable

@Serializable
data class Speaker(
    val id: Int? = null,
    val name: String,
    val country: String,
    val biography: String,
    val email: String,
    val twitterHandle: String? = null
)
