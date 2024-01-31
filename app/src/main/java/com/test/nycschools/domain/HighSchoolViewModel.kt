package com.test.nycschools.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.nycschools.data.HighSchoolRepository
import com.test.nycschools.data.HighschoolResponse
import kotlinx.coroutines.launch

class HighSchoolViewModel(private val repository: HighSchoolRepository): ViewModel() {

    private val _highSchools = MutableLiveData<List<HighschoolResponse>>()
    val highSchools: LiveData<List<HighschoolResponse>> get() = _highSchools

    init {
        viewModelScope.launch {
            _highSchools.value = repository.getHighSchools()
        }
    }

}