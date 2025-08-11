package com.airtable.interview.airtableschedule.data.repositories

import com.airtable.interview.airtableschedule.data.sources.SampleTimelineItems
import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.repositories.EventDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class EventDataRepositoryImpl : EventDataRepository {
    private val eventsFlow = MutableStateFlow(SampleTimelineItems.events.toMutableList())
    
    override fun getEvents(): Flow<List<Event>> {
        return eventsFlow
    }
    
    override suspend fun saveEvent(event: Event) {
        val currentEvents = eventsFlow.value.toMutableList()
        val existingIndex = currentEvents.indexOfFirst { it.id == event.id }
        
        if (existingIndex >= 0) {
            currentEvents[existingIndex] = event
        } else {
            currentEvents.add(event)
        }
        
        eventsFlow.value = currentEvents
    }
    
    companion object {
        @Volatile
        private var INSTANCE: EventDataRepositoryImpl? = null
        
        fun getInstance(): EventDataRepositoryImpl {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: EventDataRepositoryImpl().also { INSTANCE = it }
            }
        }
    }
}
