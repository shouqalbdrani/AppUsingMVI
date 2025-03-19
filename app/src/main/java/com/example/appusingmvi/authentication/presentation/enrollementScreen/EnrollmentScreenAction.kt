package com.example.appusingmvi.authentication.presentation.enrollementScreen

sealed class EnrollmentScreenAction {
    object CancelEnroll : EnrollmentScreenAction()
    object Enroll : EnrollmentScreenAction()
}