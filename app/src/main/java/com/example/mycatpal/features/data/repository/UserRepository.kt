package com.example.mycatpal.features.data.repository

import com.example.mycatpal.features.domain.model.User

interface UserRepository {
    suspend fun getUserData(email: String): User?
}