package com.georgimirchev.networking.data

data class MiddlewareResult<T>(
    val status: Int,
    val response: T
)
