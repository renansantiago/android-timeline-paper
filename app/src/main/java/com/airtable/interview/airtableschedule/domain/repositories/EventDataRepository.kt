package com.airtable.interview.airtableschedule.domain.repositories

import com.airtable.interview.airtableschedule.domain.models.Event
import kotlinx.coroutines.flow.Flow

interface EventDataRepository {
    fun getEvents(): Flow<List<Event>>
}
