package com.argote.api_star_wars.data.remote

import com.argote.api_star_wars.domain.remote.People
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleService {
    @GET("people")
    suspend fun getPeople(@Query("page") page: Int) : People
}