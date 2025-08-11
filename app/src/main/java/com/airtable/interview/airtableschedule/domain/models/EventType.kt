package com.airtable.interview.airtableschedule.domain.models

import androidx.compose.ui.graphics.Color

enum class EventType(val color: Color, val displayName: String) {
    PROJECT(Color(0xFF2196F3), "Project"), // Blue
    MEETING(Color(0xFF4CAF50), "Meeting"), // Green
    TASK(Color(0xFFFF9800), "Task") // Orange
}
