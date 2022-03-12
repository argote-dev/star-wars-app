package com.argote.api_star_wars.navigation

sealed class AppScreens(val route: String) {
    object PeopleScreen: AppScreens("people_screen")
}
