package com.example.sampleapp3.data.model

import kotlinx.serialization.Serializable

@Serializable
data class University(
    val name: String,
    val domains: List<String>?,
)
