package com.example.mycatpal.features.domain.repository

import android.util.Log
import com.example.mycatpal.features.data.repository.LocalUserRepository
import com.example.mycatpal.features.domain.components.Resource
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.domain.model.RealmModels.TrackedCat
import com.example.mycatpal.features.domain.model.RealmModels.TrackedUser
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import javax.inject.Inject

class LocalUserRepositoryIMPL @Inject constructor(
    private val realm: Realm
): LocalUserRepository {

    override val trackedUser: TrackedUser?
        get() = realm
            .query<TrackedUser>()
            .find()
            .firstOrNull()

    override suspend fun addTrackedUser(trackedUser: TrackedUser): Resource<Boolean>
    =try{
        if(realm.query<TrackedUser>().find().isEmpty()){
            realm.write {
                val newTrackedUser = TrackedUser().apply {
                    this.email = trackedUser.email!!
                    this.password = trackedUser.password
                    this.username = trackedUser.username
                    this.cats = trackedUser.cats
                    this._id = trackedUser._id
                }
                copyToRealm(newTrackedUser,UpdatePolicy.ALL)
            }
        }
        Resource.Success(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }

    override suspend fun mapperTrackedCats(list: List<Cat>): RealmList<TrackedCat>{
        val listNew = realmListOf<TrackedCat>()
        for (cat in list){
            Log.d("catsDb", cat.name)
            val newCat = TrackedCat().apply {
                this.name = cat.name
                this.age = cat.age
                this.breed = cat.breed
                this.gender = cat.gender
                this.birthday = cat.birthday
                this.image = cat.image
            }
            listNew.add(newCat)
            Log.d("catsDb", listNew.toString())
        }
        return listNew
    }

    override suspend fun deleteTrackedUser(): Resource<Boolean>
    =try{
        realm.write {
            this.deleteAll()
        }
        Resource.Success(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }
}