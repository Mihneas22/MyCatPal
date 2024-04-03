package com.example.mycatpal.features.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatpal.features.data.repository.LocalUserRepository
import com.example.mycatpal.features.domain.components.Resource
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.domain.model.RealmModels.TrackedCat
import com.example.mycatpal.features.domain.model.RealmModels.TrackedUser
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrackedUserViewModel @Inject constructor(
    private val repo: LocalUserRepository
): ViewModel() {

    var addTrackedUserResponse by mutableStateOf<Resource<Boolean>>(Resource.Success(false))
        private set

    var deleteTrackedUserResponse by mutableStateOf<Resource<Boolean>>(Resource.Success(false))
        private set

    var trackedCatList = realmListOf<TrackedCat>()

    val localUser: TrackedUser?
        get() = repo.trackedUser

    var checkDb by mutableStateOf<Boolean>(true)
        private set

    fun addTrackedUser(trackedUser: TrackedUser?)
    =viewModelScope.launch {
        addTrackedUserResponse = Resource.Loading
        repo.addTrackedUser(trackedUser!!)
    }

    fun mapperTrackedCats(list: List<Cat>)
    =viewModelScope.launch {
        trackedCatList = repo.mapperTrackedCats(list)
    }

    fun deleteTrackedUser()
    =viewModelScope.launch {
        deleteTrackedUserResponse = Resource.Loading
        deleteTrackedUserResponse = repo.deleteTrackedUser()
    }
}