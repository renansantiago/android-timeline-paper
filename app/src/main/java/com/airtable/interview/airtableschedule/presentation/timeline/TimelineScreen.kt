package com.airtable.interview.airtableschedule.presentation.timeline

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airtable.interview.airtableschedule.ui.timeline.TimelineView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimelineScreen(
    uiState: TimelineUiState,
    onAddEvent: () -> Unit,
    onEventClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddEvent,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add Event",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { paddingValues ->
        TimelineView(
            uiState = uiState,
            onEventClick = onEventClick,
            modifier = modifier.padding(paddingValues)
        )
    }
}
