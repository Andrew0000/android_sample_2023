package com.example.sampleapp3.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val first: String,
    val last: String,
)
