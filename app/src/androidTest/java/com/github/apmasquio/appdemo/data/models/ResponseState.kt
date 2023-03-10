package com.github.apmasquio.appdemo.data.models

data class ResponseState<out T>(val status: State, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?) =  ResponseState(State.SUCCESS, data, null)
    }
}

enum class State {
    SUCCESS,
    ERROR,
    LOADING
}