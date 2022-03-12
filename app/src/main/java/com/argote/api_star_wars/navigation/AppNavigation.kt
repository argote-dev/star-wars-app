package com.argote.api_star_wars.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.argote.api_star_wars.domain.remote.People
import com.argote.api_star_wars.ui.screens.people.PeopleScreen
import com.argote.api_star_wars.ui.screens.people.PeopleViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.PeopleScreen.route) {
        composable(AppScreens.PeopleScreen.route) {
            val viewModel = hiltViewModel<PeopleViewModel>()
            PeopleScreen(navController = navController, viewModel = viewModel)
        }
        // more screens
    }
}