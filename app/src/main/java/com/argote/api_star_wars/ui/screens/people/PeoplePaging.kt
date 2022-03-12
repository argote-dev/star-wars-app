package com.argote.api_star_wars.ui.screens.people

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.argote.api_star_wars.core.Constants
import com.argote.api_star_wars.domain.remote.Person
import com.argote.api_star_wars.usecases.GetPeople

class PeoplePaging(
    private val getPeople: GetPeople
) : PagingSource<Int, Person>() {

    override fun getRefreshKey(state: PagingState<Int, Person>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Person> = try {
        val nextPage = params.key ?: INITIAL_INDEX
        val response = getPeople.invoke(nextPage)
        var numberNextPage: Int? = null
        if (response.next != null) {
            val uri = Uri.parse(response.next)
            val nextPageQuery = uri.getQueryParameter(Constants.QUERY_PARAM_PAGE)
            numberNextPage = nextPageQuery?.toInt()
        }
        LoadResult.Page(
            data = response.results,
            prevKey = null,
            nextKey = numberNextPage
        )
    } catch (exception: Exception) {
        LoadResult.Error(exception)
    }

    companion object {
        private const val INITIAL_INDEX = 1
    }

}