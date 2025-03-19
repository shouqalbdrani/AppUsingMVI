package com.example.appusingmvi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appusingmvi.authentication.presentation.enrollementScreen.EnrollmentScreenView
import com.example.appusingmvi.authentication.presentation.enrollementScreen.EnrollmentViewModel
import com.example.appusingmvi.authentication.presentation.listScreen.ListScreenView
import com.example.appusingmvi.authentication.presentation.listScreen.ListScreenViewModel
import com.example.appusingmvi.authentication.presentation.listScreen.ListScreenViewModelFactory
import com.example.appusingmvi.authentication.domain.useCases.GetActivityUseCase
import com.example.appusingmvi.authentication.domain.models.ActivityDataModel
import com.example.appusingmvi.navigation.AppScreen
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.ListScreen.route) {
        composable(AppScreen.ListScreen.route) {
            val listScreenViewModel: ListScreenViewModel =
                viewModel(factory = ListScreenViewModelFactory(GetActivityUseCase()))
            ListScreenView(
                viewModel = listScreenViewModel,
                onActivityClick = { activity ->
                    navController.navigate(
                        AppScreen.EnrollmentScreen.createRoute(
                            activity.id,
                            activity.price,
                            activity.date
                        )
                    )
                }
            )
        }

        composable(AppScreen.EnrollmentScreen.route) { backStackEntry ->
            val activityId = backStackEntry.arguments?.getString("activityId") ?: ""
            val price = backStackEntry.arguments?.getString("price") ?: ""
            val date = backStackEntry.arguments?.getString("date") ?: ""

            val enrollmentViewModel: EnrollmentViewModel = viewModel()

            // Create the ActivityDataModel using the extracted parameters
            val activity = ActivityDataModel(
                id = activityId,
                name = "Activity $activityId",
                price = price,
                date = date
            )

            EnrollmentScreenView(
                viewModel = enrollmentViewModel,
                activity = activity,
                onEnrollClick = { enrollmentViewModel.enrollInActivity(activity.id) },
                onCancelClick = { navController.popBackStack() }
            )
        }
    }
}