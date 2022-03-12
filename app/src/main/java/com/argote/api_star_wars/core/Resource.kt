package com.argote.api_star_wars.core

import java.lang.Exception

sealed class Resource<out T> {
    object Loading: Resource<Nothing>()
    class Success<out T>(val data: T) : Resource<T>()
    class Failure(val exception: Exception) : Resource<Nothing>()
}