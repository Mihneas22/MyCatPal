package com.example.mycatpal.features.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatpal.features.data.repository.AuthRepository
import com.example.mycatpal.features.domain.components.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: AuthRepository
):ViewModel() {

    var signUpResponse by mutableStateOf<Resource<Boolean>>(Resource.Success(false))
        private set

    var createUserResponse by mutableStateOf<Resource<Boolean>>(Resource.Success(false))
        private set

    var loginInResponse by mutableStateOf<Resource<Boolean>>(Resource.Success(false))
        private set

    fun signUpUser(email: String,password: String)
    =viewModelScope.launch{
        signUpResponse = Resource.Loading
        signUpResponse = repo.signUpUser(email, password)
    }

    fun createUser(username: String,email: String,password: String)
    =viewModelScope.launch {
        createUserResponse = Resource.Loading
        createUserResponse = repo.createUser(username, email, password)
    }

    fun loginInUser(email: String,password: String)
            =viewModelScope.launch {
        loginInResponse = Resource.Loading
        loginInResponse = repo.loginInUser(email, password)
    }

    fun logOut()
    =viewModelScope.launch {
        repo.logOut()
    }
}