package com.airtable.interview.airtableschedule.ui.timeline.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimelineGridBackground(totalWidth: Long, maxLanes: Int) {
    val laneHeight = 50.dp
    val laneSpacing = 10.dp
    val timelineWidth = maxOf(1000, (totalWidth * 20)) - 32

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.small
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                shape = MaterialTheme.shapes.small
            )
    ) {
        // Horizontal lane separators
        for (i in 0..maxLanes) {
            Box(
                modifier = Modifier
                    .offset(y = (i * (50 + 10)).dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.1f))
            )
        }
        
        // Vertical time markers (every 25% of timeline)
        for (i in 0..4) {
            val position = (i.toFloat() / 4f)
            Box(
                modifier = Modifier
                    .offset(x = (position * timelineWidth).dp)
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.05f))
            )
        }
    }
}
