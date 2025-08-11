package com.airtable.interview.airtableschedule

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airtable.interview.airtableschedule.presentation.timeline.TimelineScreen
import com.airtable.interview.airtableschedule.presentation.timeline.TimelineViewModel
import com.airtable.interview.airtableschedule.ui.event.EventFormScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface {
                    var currentScreen by remember { mutableStateOf("timeline") }
                    var selectedEventId by remember { mutableStateOf<String?>(null) }
                    
                    val timelineViewModel: TimelineViewModel = viewModel()
                    
                    when (currentScreen) {
                        "timeline" -> {
                            TimelineScreen(
                                uiState = timelineViewModel.uiState.collectAsState().value,
                                onAddEvent = {
                                    selectedEventId = null
                                    currentScreen = "eventForm"
                                },
                                onEventClick = { eventId ->
                                    selectedEventId = eventId
                                    currentScreen = "eventForm"
                                }
                            )
                        }
                        "eventForm" -> {
                            EventFormScreen(
                                eventId = selectedEventId,
                                onNavigateBack = {
                                    currentScreen = "timeline"
                                    selectedEventId = null
                                },
                                onEventSaved = {
                                    timelineViewModel.refreshTimelineData()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
