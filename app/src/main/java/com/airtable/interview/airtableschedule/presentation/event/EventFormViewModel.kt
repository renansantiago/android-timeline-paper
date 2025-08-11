package com.airtable.interview.airtableschedule.presentation.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.models.EventType
import com.airtable.interview.airtableschedule.data.repositories.EventDataRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*

class EventFormViewModel : ViewModel() {
    private val eventRepository = EventDataRepositoryImpl.getInstance()
    
    private val _uiState = MutableStateFlow(EventFormUiState())
    val uiState: StateFlow<EventFormUiState> = _uiState.asStateFlow()
    
    fun loadEvent(eventId: String?) {
        if (eventId == null) {
            resetForm()
        } else {
            viewModelScope.launch {
                eventRepository.getEvents().collect { events ->
                    events.find { it.id == eventId }?.let { event ->
                        _uiState.update { currentState ->
                            currentState.copy(
                                eventId = event.id,
                                eventName = event.name,
                                startDate = event.startDate,
                                endDate = event.endDate,
                                eventType = event.eventType
                            )
                        }
                    }
                }
            }
        }
    }
    
    fun resetForm() {
        _uiState.value = EventFormUiState()
    }
    
    fun updateEventName(name: String) {
        _uiState.update { currentState ->
            currentState.copy(
                eventName = name,
                eventNameError = if (name.isBlank()) "Event name cannot be empty" else null
            )
        }
    }
    
    fun updateStartDate(date: Date) {
        _uiState.update { currentState ->
            val endDate = currentState.endDate
            currentState.copy(
                startDate = date,
                startDateError = if (date.after(endDate)) "Start date cannot be after end date" else null
            )
        }
    }
    
    fun updateEndDate(date: Date) {
        _uiState.update { currentState ->
            val startDate = currentState.startDate
            currentState.copy(
                endDate = date,
                endDateError = if (date.before(startDate)) "End date cannot be before start date" else null
            )
        }
    }
    
    fun updateEventType(eventType: EventType) {
        _uiState.update { currentState ->
            currentState.copy(eventType = eventType)
        }
    }
    
    fun saveEvent(): Boolean {
        val currentState = _uiState.value
        
        if (!currentState.isValid) return false
        
        val event = Event(
            id = currentState.eventId ?: generateEventId(),
            name = currentState.eventName,
            startDate = currentState.startDate,
            endDate = currentState.endDate,
            eventType = currentState.eventType
        )
        
        viewModelScope.launch {
            eventRepository.saveEvent(event)
        }
        
        return true
    }
    
    private fun generateEventId(): String {
        return System.currentTimeMillis().toString()
    }
}
