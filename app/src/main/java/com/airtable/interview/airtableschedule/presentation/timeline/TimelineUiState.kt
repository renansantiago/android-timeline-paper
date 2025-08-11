package com.airtable.interview.airtableschedule.presentation.timeline

import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.models.TimelineEvent

data class TimelineUiState(
    val events: List<Event> = emptyList(),
    val timelineEvents: List<TimelineEvent> = emptyList(),
    val totalDuration: Long = 0,
    val maxLanes: Int = 0
)
