package com.example.appusingmvi.authentication.presentation.enrollementScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appusingmvi.authentication.domain.models.ActivityDataModel

@Composable
fun EnrollmentScreenView(
    viewModel: EnrollmentViewModel,
    activity: ActivityDataModel,
    onEnrollClick: () -> Unit,
    onCancelClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        when (uiState) {
            is EnrollmentUiState.Loading -> {
                CircularProgressIndicator()
            }

            is EnrollmentUiState.Success -> {
                Text(text = (uiState as EnrollmentUiState.Success).message)
            }

            is EnrollmentUiState.Error -> {
                Text(text = (uiState as EnrollmentUiState.Error).errorMessage)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Activity: ${activity.name}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Price: ${activity.price}", color = Color.Gray)
                Text(text = "Date: ${activity.date}", color = Color.Gray)

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = onEnrollClick) {
                        Text("Enroll")
                    }

                    Button(
                        onClick = onCancelClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Text("Cancel")
                    }
                }
            }
        }
    }
}
