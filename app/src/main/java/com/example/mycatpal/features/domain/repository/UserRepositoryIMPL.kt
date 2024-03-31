package com.example.mycatpal.features.domain.repository

import com.example.mycatpal.features.data.repository.UserRepository
import com.example.mycatpal.features.domain.model.User
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
}