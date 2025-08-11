package com.airtable.interview.airtableschedule.ui.timeline.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.airtable.interview.airtableschedule.domain.models.TimelineEvent

@Composable
fun TimelineEventBlock(
    timelineEvent: TimelineEvent,
    maxLanes: Int,
    totalWidth: Long
) {
    val laneHeight = 50.dp
    val laneSpacing = 6.dp

    val leftOffset = (timelineEvent.startOffset.toFloat() / totalWidth.toFloat()) * 100f
    val width = (timelineEvent.width.toFloat() / totalWidth.toFloat()) * 100f
    val topOffset = (timelineEvent.lane * (50 + 6)).dp

    val eventColor = when (timelineEvent.lane % 4) {
        0 -> MaterialTheme.colorScheme.primaryContainer
        1 -> MaterialTheme.colorScheme.secondaryContainer
        2 -> MaterialTheme.colorScheme.tertiaryContainer
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    Box(
        modifier = Modifier
            .offset(
                x = (leftOffset * 0.01f * 1000).dp,
                y = topOffset
            )
            .width((width * 0.01f * 1000).dp)
            .height(laneHeight)
            .background(
                color = eventColor,
                shape = MaterialTheme.shapes.medium
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium
            )
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = timelineEvent.event.name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            maxLines = 1
        )
    }
}
