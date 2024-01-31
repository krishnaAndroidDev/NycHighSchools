package com.test.nycschools.data

import com.test.nycschools.domain.ApiClient

class HighSchoolRepository() {
    private val api: HighSchoolApi = ApiClient.createApi()

    suspend fun getHighSchools(): List<HighschoolResponse>{
        return api.getHighSchools()
    }
}