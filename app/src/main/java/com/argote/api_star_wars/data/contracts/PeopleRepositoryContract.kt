package com.argote.api_star_wars.data.contracts

import com.argote.api_star_wars.domain.remote.People

interface PeopleRepositoryContract {
    suspend fun getPeople(nextPage: Int) : People
}