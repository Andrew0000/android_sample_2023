package com.example.sampleapp3.data.repository

import com.example.sampleapp3.data.model.User
import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser(): User {
        //TODO real loading
        delay(1000)
        return User(
            name = "Andrei",
            surName = "Vorobei",
        )
    }
}
