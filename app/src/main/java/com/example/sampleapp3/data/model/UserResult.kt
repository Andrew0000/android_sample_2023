package com.example.sampleapp3.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResult(
    val results: List<User>,
)
