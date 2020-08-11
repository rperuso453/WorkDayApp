package com.example.workdayapplication.service

import com.example.workdayapplication.model.WorkDayData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object WorkDayServiceImpl {

    suspend fun getWorkDayUrl(): ServiceResult<WorkDayData> {
        return withContext(Dispatchers.IO) {
            RetrofitCallHandle.processCall {
                RetrifitService.createSerive().getWorkDayUrl()
            }
        }
    }
}