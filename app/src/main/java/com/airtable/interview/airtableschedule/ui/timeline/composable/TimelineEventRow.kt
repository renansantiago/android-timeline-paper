package com.airtable.interview.airtableschedule.ui.timeline.composable

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
fun TimelineEventRow(
    timelineEvent: TimelineEvent,
    maxLanes: Int,
    totalWidth: Long
) {
    val dateFormat = SimpleDateFormat("MMM dd", Locale.getDefault())

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .width(140.dp)
                .padding(end = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = timelineEvent.event.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height((maxLanes * 50 + 20).dp)
        ) {
            TimelineGridBackground(totalWidth, maxLanes)
            TimelineEventBlock(
                timelineEvent = timelineEvent,
                maxLanes = maxLanes,
                totalWidth = totalWidth
            )
        }

        Box(
            modifier = Modifier
                .width(120.dp)
                .padding(start = 16.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "${dateFormat.format(timelineEvent.event.startDate)} - ${dateFormat.format(timelineEvent.event.endDate)}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
