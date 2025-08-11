package com.airtable.interview.airtableschedule.data.repositories

import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.repositories.EventDataRepository
import com.airtable.interview.airtableschedule.data.sources.SampleTimelineItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EventDataRepositoryImpl : EventDataRepository {
    override fun getTimelineItems(): Flow<List<Event>> {
        return flowOf(SampleTimelineItems.timelineItems)
    }
}
