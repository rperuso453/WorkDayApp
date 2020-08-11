package com.example.workdayapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workdayapplication.service.ServiceResult
import com.example.workdayapplication.service.WorkDayServiceImpl
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val workDayStringLiveData = MutableLiveData<String>()
    fun getUrl() {
        viewModelScope.launch {
            when (
                val result = WorkDayServiceImpl.getWorkDayUrl()
                ) {
                is ServiceResult.Success -> {
                    workDayStringLiveData.value = result.data.dataString.toString()
                }
            }
        }
    }
}