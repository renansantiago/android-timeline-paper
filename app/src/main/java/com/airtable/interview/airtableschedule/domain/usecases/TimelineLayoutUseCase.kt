package com.airtable.interview.airtableschedule.domain.usecases

import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.models.TimelineEvent
import java.util.*

class TimelineLayoutUseCase {
    
    fun calculateTimelineLayout(events: List<Event>): List<TimelineEvent> {
        val validEvents = events.filter { it.endDate >= it.startDate }
        if (validEvents.isEmpty()) return emptyList()
        
        val sortedEvents = validEvents.sortedBy { it.startDate }
        val timelineEvents = mutableListOf<TimelineEvent>()
        val lanes = mutableListOf<Long>()
        
        for (event in sortedEvents) {
            val lane = findAvailableLane(event.startDate, event.endDate, lanes)
            val startOffset = calculateStartOffset(event.startDate, sortedEvents.first().startDate)
            val width = calculateWidth(event.startDate, event.endDate)
            
            timelineEvents.add(
                TimelineEvent(
                    event = event,
                    lane = lane,
                    startOffset = startOffset,
                    width = width,
                    eventType = event.eventType
                )
            )
            
            if (lane >= lanes.size) {
                lanes.add(event.endDate.time)
            } else {
                lanes[lane] = event.endDate.time
            }
        }
        
        return timelineEvents
    }
    
    private fun findAvailableLane(startDate: Date, endDate: Date, lanes: List<Long>): Int {
        for (i in lanes.indices) {
            if (lanes[i] <= startDate.time) {
                return i
            }
        }
        return lanes.size
    }
    
    private fun calculateStartOffset(eventStart: Date, timelineStart: Date): Long {
        return (eventStart.time - timelineStart.time) / (24 * 60 * 60 * 1000)
    }
    
    private fun calculateWidth(startDate: Date, endDate: Date): Long {
        return ((endDate.time - startDate.time) / (24 * 60 * 60 * 1000)) + 1
    }
}
