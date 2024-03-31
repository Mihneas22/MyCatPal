package com.example.mycatpal.features.domain.repository

import com.example.mycatpal.features.data.repository.AuthRepository
import com.example.mycatpal.features.domain.components.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryIMPL @Inject constructor(
    private val auth: FirebaseAuth,
    private val fb: FirebaseFirestore
): AuthRepository {

    override suspend fun signUpUser(email: String, password: String): Resource<Boolean>
    =try{
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    auth.currentUser?.sendEmailVerification()
                }
            }.await()
        Resource.Success(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }

    override suspend fun loginInUser(email: String, password: String): Resource<Boolean>
    =try{
        auth.signInWithEmailAndPassword(email,password).await()
        Resource.Success(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }

    override suspend fun createUser(username: String,email: String, password: String): Resource<Boolean>
    =try{
        val db = fb.collection("users").document(email)
        val user = mutableMapOf<String,Any>()
        user["user_email"] = email
        user["user_password"] = password
        user["user_name"] = username
        db.set(user)

        val cb = fb.collection("users").document(email).collection("cats").document("nullCat")
        val newCat = mutableMapOf<String,Any>()
        newCat["cat_name"] = ""
        newCat["cat_age"] = 0
        newCat["cat_gender"] = ""
        newCat["cat_breed"] = ""
        newCat["cat_birthday"] = ""
        newCat["cat_image"] = ""

        cb.set(newCat)
        Resource.Success(true)
    }catch (ex: Exception){
        Resource.Failure(ex)
    }

    override fun getAuthStateLogin(viewModelScope: CoroutineScope): StateFlow<Boolean> = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(),auth.currentUser == null)

    override fun getAuthStateData(viewModelScope: CoroutineScope): StateFlow<FirebaseUser?> = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(),auth.currentUser)

    override fun logOut() {
        auth.signOut()
    }
}