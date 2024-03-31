package com.example.mycatpal.features.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatpal.features.data.repository.UserRepository
import com.example.mycatpal.features.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserManipulationViewModel @Inject constructor(
    private val repo: UserRepository
): ViewModel() {
    val user = mutableStateOf(User("","",""))

    fun getUserData(email: String)
    =viewModelScope.launch{
        user.value = repo.getUserData(email)!!
    }
}