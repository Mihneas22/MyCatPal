package com.example.di

import com.example.mycatpal.features.data.repository.AuthRepository
import com.example.mycatpal.features.data.repository.UserRepository
import com.example.mycatpal.features.domain.repository.AuthRepositoryIMPL
import com.example.mycatpal.features.domain.repository.UserRepositoryIMPL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository = AuthRepositoryIMPL(
        auth = FirebaseAuth.getInstance(),
        fb = FirebaseFirestore.getInstance()
    )

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository = UserRepositoryIMPL(
        fb = FirebaseFirestore.getInstance()
    )
}