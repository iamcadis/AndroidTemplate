package com.apps.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.utils.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Single

@Single
@Suppress("unused")
class ApiRepository(val client: HttpClient) {

    suspend inline fun <reified T>get(url: String, requestCode: String? = null) = flow {
        try {
            emit(ApiResult.Success(client.get(url).body() as T))
        } catch (e: Exception) {
            emit(ApiResult.Failure(e, requestCode))
        }
    }.flowOn(Dispatchers.IO)

    suspend inline fun <reified T>post(url: String, data: Any, requestCode: String? = null) = flow {
        try {
            client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(data)
            }.also { response ->
                emit(ApiResult.Success(getApiResult(response) as T))
            }
        } catch (e: Exception) {
            emit(ApiResult.Failure(e, requestCode))
        }
    }.flowOn(Dispatchers.IO)

    suspend inline fun <reified T>put(url: String, data: Any, requestCode: String? = null) = flow {
        try {
            client.put(url) {
                contentType(ContentType.Application.Json)
                setBody(data)
            }.also { response ->
                emit(ApiResult.Success(getApiResult(response) as T))
            }
        } catch (e: Exception) {
            emit(ApiResult.Failure(e, requestCode))
        }
    }.flowOn(Dispatchers.IO)

    suspend inline fun <reified T>getApiResult(response: HttpResponse) = when (response.status) {
        HttpStatusCode.OK -> response.body() as T
        HttpStatusCode.NoContent -> EmptyContent as T
        else -> throw Exception()
    }

}