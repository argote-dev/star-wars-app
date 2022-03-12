package com.argote.api_star_wars.ui.screens.people

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.argote.api_star_wars.domain.remote.Person
import kotlinx.coroutines.flow.Flow

@Composable
fun PeopleScreen() {

    val peopleViewModel: PeopleViewModel = viewModel()
    val data: Flow<PagingData<Person>> = peopleViewModel.getPeople()
    PeopleList(data)
}

@Composable
fun PeopleList(people: Flow<PagingData<Person>>) {
    val lazyItems = people.collectAsLazyPagingItems()
    LazyColumn(
        contentPadding = PaddingValues(5.dp)
    ) {
        items(lazyItems) { person ->
            if (person != null) {
                PeopleItemList(person = person)
            }
        }
    }
}

@Composable
fun PeopleItemList(person: Person) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = CircleShape.copy(CornerSize(10))
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = person.name, style = MaterialTheme.typography.subtitle1)
            Text(text = person.gender)
        }
    }
}