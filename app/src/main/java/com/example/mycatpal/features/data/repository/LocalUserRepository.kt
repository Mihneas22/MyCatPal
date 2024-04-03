package com.example.mycatpal.features.data.repository

import com.example.mycatpal.features.domain.components.Resource
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.domain.model.RealmModels.TrackedCat
import com.example.mycatpal.features.domain.model.RealmModels.TrackedUser
import io.realm.kotlin.types.RealmList

interface LocalUserRepository {

    val trackedUser: TrackedUser?
    suspend fun addTrackedUser(trackedUser: TrackedUser): Resource<Boolean>

    suspend fun deleteTrackedUser(): Resource<Boolean>

    suspend fun mapperTrackedCats(list: List<Cat>): RealmList<TrackedCat>
    
}