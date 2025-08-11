package com.airtable.interview.airtableschedule.ui.timeline

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airtable.interview.airtableschedule.presentation.timeline.TimelineUiState
import com.airtable.interview.airtableschedule.ui.timeline.composable.TimelineEventBlock
import com.airtable.interview.airtableschedule.ui.timeline.composable.TimelineGridBackground
import com.airtable.interview.airtableschedule.ui.timeline.composable.TimelineHeader
import com.airtable.interview.airtableschedule.ui.timeline.composable.TimelineScale

@Composable
fun TimelineView(
    uiState: TimelineUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TimelineHeader(uiState.totalDuration)
        
        val scrollState = rememberScrollState()
        val timelineWidth = maxOf(1000, (uiState.totalDuration * 20).toInt())
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier.width(timelineWidth.dp)
            ) {
                TimelineScale(uiState.totalDuration)
                
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((uiState.maxLanes * 60 + 40).dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    ) {
                        TimelineGridBackground(uiState.totalDuration, uiState.maxLanes)
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
    }
}
