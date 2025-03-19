package com.example.appusingmvi.authentication.domain.useCases

import com.example.appusingmvi.authentication.domain.models.ActivityDataModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetActivityUseCase {

    fun execute(): Flow<List<ActivityDataModel>> = flow {
        try {
            delay(1000)
            emit(
                listOf(
                    ActivityDataModel("1", "CPR Training", "500 SAR", "03/18/2025"),
                    ActivityDataModel("2", "Patient Care Techniques", "500 SAR", "03/19/2025"),
                    ActivityDataModel("3", "Medical Ethics and Compliance", "500 SAR", "03/19/2025"),
                    ActivityDataModel("4", "Emergency Response Training", "500 SAR", "03/19/2025")
                )
            )
        } catch (e: Exception) {

            throw Exception("Failed to fetch activities: ${e.message}")
        }
    }

    }