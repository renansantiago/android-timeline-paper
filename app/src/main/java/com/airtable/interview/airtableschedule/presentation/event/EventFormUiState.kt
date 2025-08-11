package com.airtable.interview.airtableschedule.presentation.event

import com.airtable.interview.airtableschedule.domain.models.EventType
import java.util.*

data class EventFormUiState(
    val eventId: String? = null,
    val eventName: String = "",
    val startDate: Date = Date(),
    val endDate: Date = Date(),
    val eventType: EventType = EventType.TASK,
    val eventNameError: String? = null,
    val startDateError: String? = null,
    val endDateError: String? = null
) {
    val isValid: Boolean
        get() = eventName.isNotBlank() && 
                startDate.before(endDate) && 
                eventNameError == null && 
                startDateError == null && 
                endDateError == null
}
