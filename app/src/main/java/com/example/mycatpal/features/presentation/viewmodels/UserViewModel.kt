package com.example.mycatpal.features.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatpal.features.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    init {
        getAuthStateLogin()
        getAuthStateData()
    }

    fun getAuthStateLogin() = repo.getAuthStateLogin(viewModelScope)

    fun getAuthStateData() = repo.getAuthStateData(viewModelScope)
}