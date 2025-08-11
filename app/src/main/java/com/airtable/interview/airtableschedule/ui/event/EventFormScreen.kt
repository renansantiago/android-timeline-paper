package com.airtable.interview.airtableschedule.ui.event

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.airtable.interview.airtableschedule.domain.models.Event
import com.airtable.interview.airtableschedule.domain.models.EventType
import com.airtable.interview.airtableschedule.presentation.event.EventFormUiState
import com.airtable.interview.airtableschedule.presentation.event.EventFormViewModel
import com.airtable.interview.airtableschedule.ui.event.composable.EventFormContent
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventFormScreen(
    eventId: String? = null,
    onNavigateBack: () -> Unit,
    onEventSaved: () -> Unit = {},
    viewModel: EventFormViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    
    LaunchedEffect(eventId) {
        viewModel.loadEvent(eventId)
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (eventId == null) "Add Event" else "Edit Event") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (viewModel.saveEvent()) {
                                val message = if (eventId == null) "Event added successfully!" else "Event updated successfully!"
                                android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT).show()
                                onEventSaved()
                                onNavigateBack()
                            }
                        },
                        enabled = uiState.isValid
                    ) {
                        Icon(Icons.Default.Check, contentDescription = "Save")
                    }
                }
            )
        }
    ) { paddingValues ->
        EventFormContent(
            uiState = uiState,
            onEventNameChange = { viewModel.updateEventName(it) },
            onStartDateChange = { viewModel.updateStartDate(it) },
            onEndDateChange = { viewModel.updateEndDate(it) },
            onEventTypeChange = { viewModel.updateEventType(it) },
            modifier = Modifier.padding(paddingValues)
        )
    }
}
