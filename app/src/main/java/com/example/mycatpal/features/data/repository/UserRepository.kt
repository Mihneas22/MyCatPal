package com.example.mycatpal.features.data.repository

import com.example.mycatpal.features.domain.components.Resource
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.domain.model.User

interface UserRepository {
    suspend fun getUserData(email: String): User?

    suspend fun addCat(email: String,cat: Cat): Resource<Boolean>

    suspend fun getCatData(email: String,name: String): Cat?

    suspend fun getAllCats(email: String): List<Cat>

    suspend fun deleteCat(email: String,nameCat: String): Resource<Boolean>
}