package com.example.sampleapp3.data.repository

import com.example.sampleapp3.data.model.User
import com.example.sampleapp3.data.network.Api

class UserRepository(
    private val api: Api,
) {

    suspend fun getUser(): User {
        return api.getUser().results.first()
    }
}
