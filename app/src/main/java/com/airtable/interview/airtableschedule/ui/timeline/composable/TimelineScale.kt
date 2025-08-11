package com.airtable.interview.airtableschedule.ui.timeline.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TimelineScale(totalDuration: Long) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 12.dp)
    ) {
        // Date scale header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Timeline Scale",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "${totalDuration} days",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Horizontal date scale - now scrollable
        val scrollState = rememberScrollState()
        val timelineWidth = maxOf(1000, (totalDuration * 20).toInt()) - 32
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .horizontalScroll(scrollState)
                    .width(timelineWidth.dp)
                    .padding(horizontal = 16.dp)
            ) {
                // Date markers
                for (i in 0..10) {
                    val position = (i.toFloat() / 10f)
                    val days = (i * totalDuration / 10)
                    
                    Box(
                        modifier = Modifier
                            .offset(x = (position * (timelineWidth - 32)).dp)
                            .width(1.dp)
                            .height(if (i % 2 == 0) 20.dp else 10.dp)
                            .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.6f))
                    )
                    
                    if (i % 2 == 0) {
                        Text(
                            text = "${days}d",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier
                                .offset(
                                    x = (position * (timelineWidth - 32)).dp - 12.dp,
                                    y = 24.dp
                                )
                        )
                    }
                }
            }
        }
    }
}
