package com.example.workdayapplication.service

import com.example.workdayapplication.model.WorkDayData
import retrofit2.Response
import retrofit2.http.GET

interface WorkDayService {

    @GET("v1/gifs/search?q=funny+cat&api_key=dc6zaTOxFJmzC")
    suspend fun getWorkDayUrl(): Response<WorkDayData>
}