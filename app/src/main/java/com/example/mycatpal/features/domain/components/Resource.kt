package com.example.mycatpal.features.domain.components

sealed class Resource<out T> {
    data class Success<out T>(val result: T) : Resource<T>()
    data class Failure(val message: Exception) : Resource<Nothing>()

    object Loading: Resource<Nothing>()
}