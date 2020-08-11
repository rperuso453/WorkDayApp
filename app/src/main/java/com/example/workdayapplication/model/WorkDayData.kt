package com.example.workdayapplication.model

import com.google.gson.annotations.SerializedName

data class WorkDayData(
    @SerializedName("data")
    val dataString: Any?
)