package com.example.appusingmvi.authentication.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ActivityDataModel(
    val id: String,
    val name: String,
    val price: String,
    val date: String
)
