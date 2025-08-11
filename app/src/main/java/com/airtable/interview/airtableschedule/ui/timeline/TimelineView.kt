package com.airtable.interview.airtableschedule.ui.timeline

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airtable.interview.airtableschedule.presentation.timeline.TimelineUiState
import com.airtable.interview.airtableschedule.ui.timeline.composable.*

@Composable
fun TimelineView(
    uiState: TimelineUiState,
    modifier: Modifier = Modifier
) {
    if (uiState.events.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No events to display")
        }
        return
    }

    Column(modifier = modifier.fillMaxWidth()) {
        TimelineHeader(uiState.totalDuration)
        TimelineScale(uiState.totalDuration)
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(uiState.timelineEvents) { timelineEvent ->
                TimelineEventRow(
                    timelineEvent = timelineEvent,
                    maxLanes = uiState.maxLanes,
                    totalWidth = uiState.totalDuration + 10
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
