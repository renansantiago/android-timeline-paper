package com.airtable.interview.airtableschedule.data.sources

import com.airtable.interview.airtableschedule.domain.models.Event
import java.util.Date

object SampleTimelineItems {
    val timelineItems: List<Event> = listOf(
        Event(1, Date(124, 0, 1), Date(124, 0, 5), "Project Alpha"),
        Event(2, Date(124, 0, 3), Date(124, 0, 8), "Project Beta"),
        Event(3, Date(124, 0, 6), Date(124, 0, 12), "Project Gamma"),
        Event(4, Date(124, 0, 10), Date(124, 0, 15), "Project Delta"),
        Event(5, Date(124, 0, 12), Date(124, 0, 18), "Project Epsilon"),
        Event(6, Date(124, 0, 16), Date(124, 0, 22), "Project Zeta"),
        Event(7, Date(124, 0, 20), Date(124, 0, 25), "Project Eta"),
        Event(8, Date(124, 0, 22), Date(124, 0, 28), "Project Theta"),
        Event(9, Date(124, 0, 25), Date(124, 0, 30), "Project Iota"),
        Event(10, Date(124, 0, 28), Date(124, 1, 5), "Project Kappa")
    )
}
