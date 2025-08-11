package com.airtable.interview.airtableschedule.ui.timeline.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TimelineScale(
    totalDuration: Long,
    startDate: Date? = null
) {
    Column(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surface).padding(vertical = 12.dp)) {
        if (startDate != null) {
            val calendar = Calendar.getInstance()
            calendar.time = startDate
            val monthYear = SimpleDateFormat("MMM yyyy", Locale.getDefault()).format(startDate)
            
            Text(
                text = monthYear,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        val timelineWidth = maxOf(1000, (totalDuration * 20).toInt())
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(timelineWidth.dp)
                    .padding(horizontal = 16.dp)
            ) {
                if (startDate != null) {
                    val calendar = Calendar.getInstance()
                    calendar.time = startDate
                    
                    for (i in 0..totalDuration.toInt()) {
                        val currentDate = Calendar.getInstance()
                        currentDate.time = startDate
                        currentDate.add(Calendar.DAY_OF_YEAR, i)
                        
                        val dayOfMonth = currentDate.get(Calendar.DAY_OF_MONTH)
                        
                        // Show day markers every few days
                        if (i % 3 == 0 || i == totalDuration.toInt()) {
                            val position = (i.toFloat() / totalDuration.toFloat())
                            
                            Box(
                                modifier = Modifier
                                    .offset(x = (position * (timelineWidth - 32)).dp)
                                    .width(1.dp)
                                    .height(if (i % 6 == 0) 20.dp else 10.dp)
                                    .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.6f))
                            )
                            
                            if (i % 6 == 0) {
                                Box(
                                    modifier = Modifier
                                        .offset(
                                            x = (position * (timelineWidth - 32)).dp - 16.dp,
                                            y = 24.dp
                                        )
                                        .width(32.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${dayOfMonth}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
