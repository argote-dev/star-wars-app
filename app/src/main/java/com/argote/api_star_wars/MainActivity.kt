package com.argote.api_star_wars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.argote.api_star_wars.navigation.AppNavigation
import com.argote.api_star_wars.ui.screens.people.PeopleScreen
import com.argote.api_star_wars.ui.theme.ApistarwarsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApistarwarsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    AppNavigation()
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApistarwarsTheme {}
}