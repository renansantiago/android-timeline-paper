package com.airtable.interview.airtableschedule.data.sources

import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.models.EventType
import java.util.*

object SampleTimelineItems {
    
    val events = listOf(
        Event(
            id = "1",
            name = "Project Alpha",
            startDate = Date(125, 7, 1), // Aug 1, 2025
            endDate = Date(125, 7, 5),   // Aug 5, 2025
            eventType = EventType.PROJECT
        ),
        Event(
            id = "2",
            name = "Project Beta",
            startDate = Date(125, 7, 3), // Aug 3, 2025
            endDate = Date(125, 7, 8),   // Aug 8, 2025
            eventType = EventType.PROJECT
        ),
        Event(
            id = "3",
            name = "Team Meeting",
            startDate = Date(125, 7, 6), // Aug 6, 2025
            endDate = Date(125, 7, 6),   // Aug 6, 2025
            eventType = EventType.MEETING
        ),
        Event(
            id = "4",
            name = "Code Review",
            startDate = Date(125, 7, 10), // Aug 10, 2025
            endDate = Date(125, 7, 15),   // Aug 15, 2025
            eventType = EventType.TASK
        ),
        Event(
            id = "5",
            name = "Project Gamma",
            startDate = Date(125, 7, 12), // Aug 12, 2025
            endDate = Date(125, 7, 18),   // Aug 18, 2025
            eventType = EventType.PROJECT
        ),
        Event(
            id = "6",
            name = "Sprint Planning",
            startDate = Date(125, 7, 20), // Aug 20, 2025
            endDate = Date(125, 7, 20),   // Aug 20, 2025
            eventType = EventType.MEETING
        ),
        Event(
            id = "7",
            name = "Bug Fixes",
            startDate = Date(125, 7, 22), // Aug 22, 2025
            endDate = Date(125, 7, 25),   // Aug 25, 2025
            eventType = EventType.TASK
        ),
        Event(
            id = "8",
            name = "Project Delta",
            startDate = Date(125, 7, 25), // Aug 25, 2025
            endDate = Date(125, 7, 30),   // Aug 30, 2025
            eventType = EventType.PROJECT
        )
    )
}
