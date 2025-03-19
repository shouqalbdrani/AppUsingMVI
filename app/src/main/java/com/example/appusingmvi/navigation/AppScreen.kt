package com.example.appusingmvi.navigation

sealed class AppScreen(val route: String) {
    object ListScreen : AppScreen("list_screen")

    object EnrollmentScreen : AppScreen("enrollment_screen/{activityId}/{price}/{date}") {
        fun createRoute(activityId: String, price: String, date: String): String {
            return "enrollment_screen/$activityId/$price/$date"
        }
    }
}