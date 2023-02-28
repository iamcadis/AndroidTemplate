package com.apps.data.remote

sealed class ApiResult<out R> {
    object Loading: ApiResult<Nothing>()
    data class Success<out R>(val data: R): ApiResult<R>()
    data class Failure(val exception: Exception, val requestCode: String?): ApiResult<Nothing>()
}