package com.example.appusingmvi.authentication.presentation.enrollementScreen

sealed class EnrollmentUiState {
    object Loading : EnrollmentUiState()
    data class Success(val message: String) : EnrollmentUiState()
    data class Error(val errorMessage: String) : EnrollmentUiState()
}