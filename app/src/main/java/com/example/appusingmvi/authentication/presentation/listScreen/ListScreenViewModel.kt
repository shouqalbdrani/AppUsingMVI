package com.example.appusingmvi.authentication.presentation.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appusingmvi.authentication.domain.models.ActivityDataModel
import com.example.appusingmvi.authentication.domain.useCases.GetActivityUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListScreenViewModel(
    private val getActivityUseCase: GetActivityUseCase
) : ViewModel() {

    private val _activities = MutableStateFlow<List<ActivityDataModel>>(emptyList())
    val activities: StateFlow<List<ActivityDataModel>> = _activities

    init {
        getActivities()
    }

    private fun getActivities() {
        viewModelScope.launch {
            getActivityUseCase.execute().collect { activityList ->
                _activities.value = activityList
            }
        }
    }
}
