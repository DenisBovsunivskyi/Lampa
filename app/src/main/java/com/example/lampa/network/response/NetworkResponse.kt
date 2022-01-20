package com.example.lampa.network.response

import java.io.IOException

sealed class NetworkResponse<out T : BaseResponse> {
    sealed class Success<K : BaseResponse> : NetworkResponse<K>() {
        data class Result<K : BaseResponse>(val body: K) : Success<K>()
        object Empty : Success<Nothing>()
    }
    }
