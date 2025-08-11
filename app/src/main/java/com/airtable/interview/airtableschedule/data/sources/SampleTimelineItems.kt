package com.airtable.interview.airtableschedule.data.sources

import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.models.EventType
import java.util.*

object SampleTimelineItems {
    
    val events = listOf(
        Event(
            id = "1",
            name = "Project Alpha",
            startDate = Date(120, 0, 1), // Jan 1, 2020
            endDate = Date(120, 0, 5),   // Jan 5, 2020
            eventType = EventType.PROJECT
        ),
        Event(
            id = "2",
            name = "Project Beta",
            startDate = Date(120, 0, 3), // Jan 3, 2020
            endDate = Date(120, 0, 8),   // Jan 8, 2020
            eventType = EventType.PROJECT
        ),
        Event(
            id = "3",
            name = "Team Meeting",
            startDate = Date(120, 0, 6), // Jan 6, 2020
            endDate = Date(120, 0, 6),   // Jan 6, 2020
            eventType = EventType.MEETING
        ),
        Event(
            id = "4",
            name = "Code Review",
            startDate = Date(120, 0, 10), // Jan 10, 2020
            endDate = Date(120, 0, 15),   // Jan 15, 2020
            eventType = EventType.TASK
        ),
        Event(
            id = "5",
            name = "Project Gamma",
            startDate = Date(120, 0, 12), // Jan 12, 2020
            endDate = Date(120, 0, 18),   // Jan 18, 2020
            eventType = EventType.PROJECT
        ),
        Event(
            id = "6",
            name = "Sprint Planning",
            startDate = Date(120, 0, 20), // Jan 20, 2020
            endDate = Date(120, 0, 20),   // Jan 20, 2020
            eventType = EventType.MEETING
        ),
        Event(
            id = "7",
            name = "Bug Fixes",
            startDate = Date(120, 0, 22), // Jan 22, 2020
            endDate = Date(120, 0, 25),   // Jan 25, 2020
            eventType = EventType.TASK
        ),
        Event(
            id = "8",
            name = "Project Delta",
            startDate = Date(120, 0, 25), // Jan 25, 2020
            endDate = Date(120, 0, 30),   // Jan 30, 2020
            eventType = EventType.PROJECT
        )
    )
}
