package com.test.nycschools.data

import retrofit2.http.GET

interface HighSchoolApi {
    @GET("")
    suspend fun getHighSchools():List<HighschoolResponse>
}