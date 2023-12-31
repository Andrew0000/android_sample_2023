package com.example.sampleapp3.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: Name,
    val email: String,
)
