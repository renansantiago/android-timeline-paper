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
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TimelineEventBlock(
    timelineEvent: TimelineEvent,
    maxLanes: Int,
    totalWidth: Long
) {
    val laneHeight = 50.dp
    val laneSpacing = 10.dp
    
    val timelineWidth = maxOf(1000, (totalWidth * 20).toInt()) - 32
    val leftOffset = (timelineEvent.startOffset.toFloat() / totalWidth.toFloat()) * timelineWidth
    val width = (timelineEvent.width.toFloat() / totalWidth.toFloat()) * timelineWidth
    val topOffset = timelineEvent.lane * (50 + 10)

    val dateFormat = SimpleDateFormat("MMM dd", Locale.getDefault())
    val startDateStr = dateFormat.format(timelineEvent.event.startDate)
    val endDateStr = dateFormat.format(timelineEvent.event.endDate)
    val dateRange = if (timelineEvent.event.startDate == timelineEvent.event.endDate) {
        startDateStr
    } else {
        "$startDateStr - $endDateStr"
    }

    Box(
        modifier = Modifier
            .offset(
                x = leftOffset.dp,
                y = topOffset.dp
            )
            .width(maxOf(width.dp, 80.dp))
            .height(laneHeight)
            .background(
                color = timelineEvent.eventType.color,
                shape = MaterialTheme.shapes.medium
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                shape = MaterialTheme.shapes.medium
            )
            .padding(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = timelineEvent.event.name,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1
            )
            Text(
                text = dateRange,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f),
                maxLines = 1
            )
        }
    }
}
