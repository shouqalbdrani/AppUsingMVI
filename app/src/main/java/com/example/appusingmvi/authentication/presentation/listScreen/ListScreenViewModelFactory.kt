package com.example.appusingmvi.authentication.presentation.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appusingmvi.authentication.domain.useCases.GetActivityUseCase

class ListScreenViewModelFactory(
    private val getActivityUseCase: GetActivityUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListScreenViewModel::class.java)) {
            return ListScreenViewModel(getActivityUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}