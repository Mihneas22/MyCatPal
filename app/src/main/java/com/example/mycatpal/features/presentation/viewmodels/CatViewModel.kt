package com.example.mycatpal.features.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatpal.features.data.repository.UserRepository
import com.example.mycatpal.features.domain.components.Resource
import com.example.mycatpal.features.domain.model.Cat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val repo: UserRepository
): ViewModel(){

    var addCat by mutableStateOf<Resource<Boolean>>(Resource.Success(false))
        private set

    var cat = mutableStateOf(Cat("","","","","",""))

    val allCats = mutableStateOf(listOf<Cat>())
    fun addCat(email: String,cat: Cat)
    =viewModelScope.launch {
        addCat = Resource.Loading
        addCat = repo.addCat(email, cat)
    }

    fun getCatData(email: String, name: String)
    =viewModelScope.launch {
        cat.value = repo.getCatData(email, name)!!
    }

    fun getAllCatData(email: String)
    =viewModelScope.launch {
        allCats.value = repo.getAllCats(email)
    }
}