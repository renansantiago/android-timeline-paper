package com.airtable.interview.airtableschedule.presentation.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airtable.interview.airtableschedule.data.repositories.EventDataRepositoryImpl
import com.airtable.interview.airtableschedule.domain.usecases.TimelineLayoutUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class TimelineViewModel : ViewModel() {
    private val eventDataRepository: EventDataRepositoryImpl = EventDataRepositoryImpl()
    private val timelineLayoutUseCase: TimelineLayoutUseCase = TimelineLayoutUseCase()

    val uiState: StateFlow<TimelineUiState> = eventDataRepository
        .getTimelineItems()
        .map { events ->
            val timelineEvents = timelineLayoutUseCase.calculateLayout(events)
            val totalDuration = if (events.isNotEmpty()) {
                val earliestDate = events.minOf { it.startDate }
                val latestDate = events.maxOf { it.endDate }
                (latestDate.time - earliestDate.time) / (24 * 60 * 60 * 1000)
            } else 0
            val maxLanes = (timelineEvents.maxOfOrNull { it.lane } ?: 0) + 1
            TimelineUiState(
                events = events,
                timelineEvents = timelineEvents,
                totalDuration = totalDuration,
                maxLanes = maxLanes
            )
        }
        .stateIn(
            viewModelScope,
            initialValue = TimelineUiState(),
            started = SharingStarted.WhileSubscribed()
        )
}
