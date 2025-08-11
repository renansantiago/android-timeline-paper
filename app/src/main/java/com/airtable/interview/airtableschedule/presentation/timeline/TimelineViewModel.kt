package com.airtable.interview.airtableschedule.presentation.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airtable.interview.airtableschedule.data.repositories.EventDataRepositoryImpl
import com.airtable.interview.airtableschedule.domain.usecases.TimelineLayoutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimelineViewModel : ViewModel() {
    
    private val eventRepository = EventDataRepositoryImpl()
    private val timelineLayoutUseCase = TimelineLayoutUseCase()
    
    private val _uiState = MutableStateFlow(TimelineUiState())
    val uiState: StateFlow<TimelineUiState> = _uiState.asStateFlow()
    
    init {
        loadTimelineData()
    }
    
    private fun loadTimelineData() {
        viewModelScope.launch {
            eventRepository.getEvents().collect { events ->
                if (events.isNotEmpty()) {
                    val timelineEvents = timelineLayoutUseCase.calculateTimelineLayout(events)
                    val totalDuration = calculateTotalDuration(events)
                    val maxLanes = timelineEvents.maxOfOrNull { it.lane }?.plus(1) ?: 0
                    
                    _uiState.value = TimelineUiState(
                        events = events,
                        timelineEvents = timelineEvents,
                        totalDuration = totalDuration,
                        maxLanes = maxLanes
                    )
                }
            }
        }
    }
    
    private fun calculateTotalDuration(events: List<com.airtable.interview.airtableschedule.domain.models.Event>): Long {
        if (events.isEmpty()) return 0
        
        val earliestStart = events.minOf { it.startDate }
        val latestEnd = events.maxOf { it.endDate }
        return ((latestEnd.time - earliestStart.time) / (24 * 60 * 60 * 1000)) + 1
    }
}
