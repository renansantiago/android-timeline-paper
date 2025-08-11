package com.airtable.interview.airtableschedule.domain.usecases

import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.models.TimelineEvent
import java.util.Date

class TimelineLayoutUseCase {
    fun calculateLayout(events: List<Event>): List<TimelineEvent> {
        if (events.isEmpty()) return emptyList()
        val validEvents = events.filter { it.endDate >= it.startDate }
        if (validEvents.isEmpty()) return emptyList()
        val sortedEvents = validEvents.sortedBy { it.startDate }
        val lanes = mutableListOf<Date>()
        val result = mutableListOf<TimelineEvent>()
        for (event in sortedEvents) {
            val laneIndex = findAvailableLane(lanes, event.startDate)
            if (laneIndex >= lanes.size) {
                lanes.add(event.endDate)
            } else {
                lanes[laneIndex] = event.endDate
            }
            val startOffset = calculateStartOffset(event.startDate, validEvents)
            val width = calculateWidth(event.startDate, event.endDate, validEvents)
            result.add(TimelineEvent(event, laneIndex, startOffset, width))
        }
        return result
    }

    private fun findAvailableLane(lanes: List<Date>, startDate: Date): Int {
        for (i in lanes.indices) {
            if (startDate >= lanes[i]) {
                return i
            }
        }
        return lanes.size
    }

    private fun calculateStartOffset(startDate: Date, allEvents: List<Event>): Long {
        val earliestDate = allEvents.minOf { it.startDate }
        return (startDate.time - earliestDate.time) / (24 * 60 * 60 * 1000)
    }

    private fun calculateWidth(startDate: Date, endDate: Date, allEvents: List<Event>): Long {
        return (endDate.time - startDate.time) / (24 * 60 * 60 * 1000) + 1
    }
}
