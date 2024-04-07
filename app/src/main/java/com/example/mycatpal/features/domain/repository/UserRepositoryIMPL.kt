package com.example.mycatpal.features.domain.repository

import androidx.compose.runtime.mutableStateOf
import com.example.mycatpal.features.data.repository.UserRepository
import com.example.mycatpal.features.domain.components.Resource
import com.example.mycatpal.features.domain.model.Cat
import com.example.mycatpal.features.domain.model.User
import com.google.android.play.integrity.internal.f
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryIMPL @Inject constructor(
    private val fb: FirebaseFirestore
):  UserRepository {

    override suspend fun getUserData(email: String): User? {
        val db = fb.collection("users").document(email).get().await().data
        return (db?.get("user_email") as? String)?.let {
            User(
                it,
                (db["user_password"] as? String)!!,
                (db["user_name"] as? String)!!
            )
        }
    }

    override suspend fun addCat(email: String,cat: Cat): Resource<Boolean>
    =try{
        val db = fb.collection("users").document(email).collection("cats").document(cat.name)
        val newCat = mutableMapOf<String,Any>()
        newCat["cat_name"] = cat.name
        newCat["cat_age"] = cat.age
        newCat["cat_gender"] = cat.gender
        newCat["cat_breed"] = cat.breed
        newCat["cat_birthday"] = cat.birthday
        newCat["cat_image"] = cat.image

        db.set(newCat)
        Resource.Success(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }

    override suspend fun getCatData(email: String,name: String): Cat?{
        val db = fb.collection("users").document(email).collection("cats").document(name).get().await().data
        return (db?.get("cat_name") as? String)?.let {
            (db["cat_age"] as? String)?.let { it1 ->
                Cat(
                    it,
                    it1,
                    (db["cat_gender"] as? String)!!,
                    (db["cat_breed"] as? String)!!,
                    (db["cat_birthday"] as? String)!!,
                    (db["cat_image"] as? String)!!
                )
            }
        }
    }

    override suspend fun getAllCats(email: String): List<Cat> {
        val catList = mutableListOf<Cat>()
        val db = fb.collection("users").document(email).collection("cats").get().await().documents

        for(document in db)
        {
            val cat = mutableStateOf(Cat("","0","","","","0"))
            cat.value.name = (document?.get("cat_name") as? String?).toString()
            cat.value.age = (document?.get("cat_age") as? String?)?.toString()!!
            cat.value.gender = (document.get("cat_gender") as? String?).toString()
            cat.value.breed = (document.get("cat_breed") as? String?).toString()
            cat.value.birthday = (document.get("cat_birthday") as? String?).toString()
            cat.value.image = (document.get("cat_image") as? String?)?.toString()!!

            catList.add(cat.value)
        }
        return catList.toList()
    }

    override suspend fun deleteCat(email: String, nameCat: String): Resource<Boolean>
    =try{
        val db = fb.collection("users").document(email).collection("cats").document(nameCat)
        db.delete()
        Resource.Success(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }
}