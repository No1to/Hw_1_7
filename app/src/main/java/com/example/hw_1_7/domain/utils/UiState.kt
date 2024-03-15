package com.example.hw_1_7.domain.utils

sealed class UiState<T>(
    val data:T ?= null,
    val message:String ?= null
){
    class Loading<T>: UiState<T>()
    class Success<T>(data: T): UiState<T>(data = data)
    class Empty<T>(message: String): UiState<T>(message = message)
    class Error<T>(message: String?): UiState<T>(message = message)
}