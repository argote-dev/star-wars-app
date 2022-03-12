package com.argote.api_star_wars.data

import com.argote.api_star_wars.data.contracts.PeopleRepositoryContract
import com.argote.api_star_wars.data.remote.PeopleService
import com.argote.api_star_wars.domain.remote.People
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val service: PeopleService
) : PeopleRepositoryContract {

    override suspend fun getPeople(nextPage: Int): People {
        return service.getPeople(nextPage)
    }

}