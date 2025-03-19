package com.example.appusingmvi.authentication.presentation.listScreen

import com.example.appusingmvi.authentication.domain.models.ActivityDataModel

sealed class ListUiState {
    object Loading : ListUiState()
    data class Success(val activities: List<ActivityDataModel>) : ListUiState()
    data class Error(val errorMessage: String) : ListUiState()
}