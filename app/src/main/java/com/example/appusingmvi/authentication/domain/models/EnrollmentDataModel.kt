package com.example.appusingmvi.authentication.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class EnrollmentDataModel(
    val activityDescription: String,
    val location : String ,
    val startAndEndTime : String
)
