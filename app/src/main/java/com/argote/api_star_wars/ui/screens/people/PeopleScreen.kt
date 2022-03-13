package com.argote.api_star_wars.ui.screens.people

import android.content.Context
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.argote.api_star_wars.R
import com.argote.api_star_wars.domain.remote.Person
import kotlinx.coroutines.flow.Flow

@Composable
fun PeopleScreen(navController: NavController, viewModel: PeopleViewModel) {
    val data: Flow<PagingData<Person>> = viewModel.getPeople()
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
    val context: Context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, person.name, Toast.LENGTH_SHORT)
                    .show()
            },
        elevation = 8.dp,
        shape = CircleShape.copy(CornerSize(10))
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.logo_characters),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = person.name, style = MaterialTheme.typography.subtitle1)
            }
        }
    }
    Spacer(modifier = Modifier.height(5.dp))
}