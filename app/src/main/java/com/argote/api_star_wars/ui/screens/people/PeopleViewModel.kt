package com.argote.api_star_wars.ui.screens.people

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.argote.api_star_wars.domain.remote.Person
import com.argote.api_star_wars.usecases.GetPeople
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeople
) : ViewModel() {

    fun getPeople(): Flow<PagingData<Person>> = Pager(
        config = PagingConfig(pageSize = 80)
    ) {
        PeoplePaging(getPeopleUseCase)
    }.flow

}