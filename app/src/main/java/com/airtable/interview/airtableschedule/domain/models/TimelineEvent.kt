package com.airtable.interview.airtableschedule.domain.models

data class TimelineEvent(
    val event: Event,
    val lane: Int,
    val startOffset: Long,
    val width: Long
)
