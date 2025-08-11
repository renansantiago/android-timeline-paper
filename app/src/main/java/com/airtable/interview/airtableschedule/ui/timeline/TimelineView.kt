package com.airtable.interview.airtableschedule.ui.timeline

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
        
        // Timeline grid with events - now horizontally scrollable
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((uiState.maxLanes * 60 + 40).dp)
        ) {
            val scrollState = rememberScrollState()
            val timelineWidth = maxOf(1000, (uiState.totalDuration * 20).toInt())
            
            Box(
                modifier = Modifier
                    .horizontalScroll(scrollState)
                    .width(timelineWidth.dp)
                    .padding(horizontal = 16.dp)
            ) {
                TimelineGridBackground(uiState.totalDuration, uiState.maxLanes)
                
                // Render all timeline events
                uiState.timelineEvents.forEach { timelineEvent ->
                    TimelineEventBlock(
                        timelineEvent = timelineEvent,
                        maxLanes = uiState.maxLanes,
                        totalWidth = uiState.totalDuration
                    )
                }
            }
        }
    }
}
