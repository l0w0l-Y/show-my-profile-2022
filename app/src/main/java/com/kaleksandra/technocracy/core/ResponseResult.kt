package com.kaleksandra.technocracy.core

sealed class ResponseResult<out T> {
    data class Success<T>(val body: T) : ResponseResult<T>()
    data class Error<T>(val code: Int, val message: String = "") : ResponseResult<T>()
    data class Loading<T>(val unit: Unit) : ResponseResult<T>()
}