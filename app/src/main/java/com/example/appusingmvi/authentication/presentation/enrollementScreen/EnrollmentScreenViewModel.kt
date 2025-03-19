package com.example.appusingmvi.authentication.presentation.enrollementScreen

import com.example.appusingmvi.authentication.domain.useCases.EnrollActivityUseCase // Correct import statement
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class EnrollmentViewModel(
    private val enrollActivityUseCase: EnrollActivityUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<EnrollmentUiState>(EnrollmentUiState.Loading)
    val uiState: StateFlow<EnrollmentUiState> = _uiState

    fun enrollInActivity(activityId: String) {
        viewModelScope.launch {
            _uiState.value = EnrollmentUiState.Loading
            try {
                delay(1000)
                val isEnrolled = enrollActivityUseCase.execute(activityId)
                if (isEnrolled) {
                    _uiState.value = EnrollmentUiState.Success("Successfully enrolled!")
                } else {
                    _uiState.value = EnrollmentUiState.Error("Enrollment failed")
                }
            } catch (e: Exception) {
                _uiState.value = EnrollmentUiState.Error("An error occurred: ${e.message}")
            }
        }
    }
}