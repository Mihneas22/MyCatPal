package com.example.mycatpal.features.data.repository

import com.example.mycatpal.features.domain.components.Resource
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {

    suspend fun signUpUser(email: String,password: String): Resource<Boolean>

    suspend fun loginInUser(email: String,password: String): Resource<Boolean>

    suspend fun createUser(username: String,email: String,password: String): Resource<Boolean>

    fun getAuthStateLogin(viewModelScope: CoroutineScope): StateFlow<Boolean>

    fun getAuthStateData(viewModelScope: CoroutineScope): StateFlow<FirebaseUser?>

    fun logOut()
}