package com.airtable.interview.airtableschedule.domain.models

import java.util.Date

data class Event(
    val id: String,
    val name: String,
    val startDate: Date,
    val endDate: Date,
    val eventType: EventType
)
