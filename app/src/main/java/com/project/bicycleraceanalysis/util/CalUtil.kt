package com.project.bicycleraceanalysis.util

import java.text.SimpleDateFormat
import java.util.*

fun getAgeFromYear(year: String) : Int {

    val cal: Calendar = Calendar.getInstance()
    val formats: SimpleDateFormat = SimpleDateFormat("yyyy")
    val time2 = formats.format(cal.time).toInt()
    val ageSum: Int = year.toInt()

    return time2 - ageSum
}