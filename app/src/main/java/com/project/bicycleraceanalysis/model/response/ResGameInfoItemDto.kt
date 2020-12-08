package com.project.bicycleraceanalysis.model.response

data class ResGameInfoItemDto(
        val id: Int,
        val schedule_code: String,
        val schedule_content: String,
        val schedule_day: String,
        val schedule_month: String,
        val schedule_year: String,
        val title: String
)