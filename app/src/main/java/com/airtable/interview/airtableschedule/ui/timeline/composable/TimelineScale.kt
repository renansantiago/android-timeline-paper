package com.airtable.interview.airtableschedule.ui.timeline.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TimelineScale(totalDuration: Long) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Timeline Scale",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.width(140.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(30.dp)
        ) {
            for (i in 0..10) {
                val position = (i.toFloat() / 10f) * 100f
                Box(
                    modifier = Modifier
                        .offset(x = (position * 0.01f * 1000).dp)
                        .width(1.dp)
                        .height(if (i % 2 == 0) 20.dp else 10.dp)
                        .background(MaterialTheme.colorScheme.outline)
                )

                if (i % 2 == 0) {
                    Text(
                        text = "${(i * totalDuration / 10)}d",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .offset(
                                x = (position * 0.01f * 1000).dp - 10.dp,
                                y = 22.dp
                            )
                    )
                }
            }
        }
    }
}
