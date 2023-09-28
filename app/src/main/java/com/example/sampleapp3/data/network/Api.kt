package com.example.sampleapp3.data.network

import com.example.sampleapp3.data.model.University
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Api {

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getUniversities(): List<University> {
        val response = client.get("http://universities.hipolabs.com/search?country=United+States")
        return response.body()
    }
}
