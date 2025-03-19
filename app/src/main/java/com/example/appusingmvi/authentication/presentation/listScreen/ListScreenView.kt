package com.example.appusingmvi.authentication.presentation.listScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appusingmvi.authentication.domain.models.ActivityDataModel

@Composable
fun ListScreenView(
    viewModel: ListScreenViewModel,
    onActivityClick: (ActivityDataModel) -> Unit
) {
    val activities = viewModel.activities.collectAsState().value

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(activities) { activity ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onActivityClick(activity)
                    },
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
                }
            }
        }
    }
}
