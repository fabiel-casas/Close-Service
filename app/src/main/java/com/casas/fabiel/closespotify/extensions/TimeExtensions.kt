package com.casas.fabiel.closespotify.extensions

fun Int.toTimeUnits(): String {
    if (this <= 10) {
        return "0$this"
    }
    return this.toString()
}

fun Long.toHoursTime(): Int {
    val hoursTime = 3600000L
    val hourInteger: Int = (this / hoursTime).toInt()
    return hourInteger
}

fun Long.toMinutesTime(): Int {
    val hoursTime = 3600000L
    val minuteTime = 60000L
    val hourRes = (this % hoursTime)
    val minutesInteger: Int = (hourRes / minuteTime).toInt()
    return minutesInteger
}

fun Long.toSecondsTime(): Int {
    val minuteTime = 60000L
    val secondsInteger: Int = (this % minuteTime).toInt()
    return secondsInteger / 1000
}