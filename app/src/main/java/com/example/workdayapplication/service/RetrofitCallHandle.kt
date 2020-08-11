package com.example.workdayapplication.service

import retrofit2.Response
import java.lang.Exception

object RetrofitCallHandle {

    suspend fun <T> processCall(
        call: suspend () -> Response<T>
    ): ServiceResult<T> {
        return try {
            val serviceCallback = call()
            val body = serviceCallback.body()
            if (serviceCallback.isSuccessful && body != null) {
                ServiceResult.Success(body)
            } else {
                ServiceResult.Error(Exception("${serviceCallback.code()}"))
            }
        } catch (e: Exception) {
            ServiceResult.Error(e)
        }
    }
}