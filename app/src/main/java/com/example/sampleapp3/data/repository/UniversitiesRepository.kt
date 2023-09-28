package com.example.sampleapp3.data.repository

import com.example.sampleapp3.data.model.University
import com.example.sampleapp3.data.network.Api

class UniversitiesRepository(
    private val api: Api,
) {

    suspend fun getUniversities(): List<University> {
        return api.getUniversities()
    }
}
