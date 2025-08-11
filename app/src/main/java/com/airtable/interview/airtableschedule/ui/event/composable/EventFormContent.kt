package com.airtable.interview.airtableschedule.ui.event.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airtable.interview.airtableschedule.domain.models.EventType
import com.airtable.interview.airtableschedule.presentation.event.EventFormUiState
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventFormContent(
    uiState: EventFormUiState,
    onEventNameChange: (String) -> Unit,
    onStartDateChange: (Date) -> Unit,
    onEndDateChange: (Date) -> Unit,
    onEventTypeChange: (EventType) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = uiState.eventName,
            onValueChange = onEventNameChange,
            label = { Text("Event Name") },
            modifier = Modifier.fillMaxWidth(),
            isError = uiState.eventNameError != null
        )
        
        if (uiState.eventNameError != null) {
            Text(
                text = uiState.eventNameError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
        
        EventTypeSelector(
            selectedType = uiState.eventType,
            onTypeSelected = onEventTypeChange
        )
        
        DateSelector(
            label = "Start Date",
            selectedDate = uiState.startDate,
            onDateSelected = onStartDateChange,
            isError = uiState.startDateError != null
        )
        
        if (uiState.startDateError != null) {
            Text(
                text = uiState.startDateError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
        
        DateSelector(
            label = "End Date",
            selectedDate = uiState.endDate,
            onDateSelected = onEndDateChange,
            isError = uiState.endDateError != null
        )
        
        if (uiState.endDateError != null) {
            Text(
                text = uiState.endDateError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
        
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun EventTypeSelector(
    selectedType: EventType,
    onTypeSelected: (EventType) -> Unit
) {
    Column {
        Text(
            text = "Event Type",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EventType.values().forEach { eventType ->
                FilterChip(
                    onClick = { onTypeSelected(eventType) },
                    label = { Text(eventType.displayName) },
                    selected = selectedType == eventType,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = eventType.color.copy(alpha = 0.2f)
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DateSelector(
    label: String,
    selectedDate: Date,
    onDateSelected: (Date) -> Unit,
    isError: Boolean = false
) {
    var showDatePicker by remember { mutableStateOf(false) }
    
    OutlinedTextField(
        value = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(selectedDate),
        onValueChange = { },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        isError = isError,
        trailingIcon = {
            TextButton(onClick = { showDatePicker = true }) {
                Text("Select")
            }
        }
    )
    
    if (showDatePicker) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = selectedDate.time
        )
        
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            // Create a Calendar instance and set it to the selected date
                            // This ensures we get the correct local date without timezone issues
                            val calendar = Calendar.getInstance()
                            calendar.timeInMillis = millis
                            
                            // Handling picker offset issue
                            calendar.add(Calendar.DAY_OF_YEAR, 1)
                            
                            // Create a new Date object with just the date components
                            val localCalendar = Calendar.getInstance()
                            localCalendar.set(calendar.get(Calendar.YEAR), 
                                           calendar.get(Calendar.MONTH), 
                                           calendar.get(Calendar.DAY_OF_MONTH))
                            localCalendar.set(Calendar.HOUR_OF_DAY, 0)
                            localCalendar.set(Calendar.MINUTE, 0)
                            localCalendar.set(Calendar.SECOND, 0)
                            localCalendar.set(Calendar.MILLISECOND, 0)
                            
                            onDateSelected(localCalendar.time)
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                showModeToggle = false
            )
        }
    }
}
