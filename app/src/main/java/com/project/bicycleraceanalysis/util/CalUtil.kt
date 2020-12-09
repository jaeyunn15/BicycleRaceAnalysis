package com.project.bicycleraceanalysis.util

import android.text.TextUtils.replace
import com.project.bicycleraceanalysis.di.remoteDataSourceModule
import java.text.SimpleDateFormat
import java.util.*

fun getAgeFromYear(year: String) : Int {

    val cal: Calendar = Calendar.getInstance()
    val formats: SimpleDateFormat = SimpleDateFormat("yyyy")
    val time2 = formats.format(cal.time).toInt()
    val ageSum: Int = year.toInt()

    return time2 - ageSum
}

fun getConvert(num:Int) : Int{
    val a = num.toString().substring(num.toString().lastIndexOf("0")+1);
    return Integer.parseInt(a)
}