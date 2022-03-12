package com.argote.api_star_wars.usecases

import com.argote.api_star_wars.data.PeopleRepository
import javax.inject.Inject

class GetPeople @Inject constructor(
    private val peopleRepository: PeopleRepository
) {
   suspend operator fun invoke(nextPage: Int) = peopleRepository.getPeople(nextPage)
}