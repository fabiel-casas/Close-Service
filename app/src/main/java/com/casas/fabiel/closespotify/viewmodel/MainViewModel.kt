package com.casas.fabiel.closespotify.viewmodel

import android.app.PendingIntent
import android.app.AlarmManager
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import com.casas.fabiel.closespotify.services.CloseServiceIntent
import java.util.*


class MainViewModel(private val context: Context) {
    private var alarmManager: AlarmManager? = null
    private var alarmIntent: PendingIntent? = null

    companion object {
        val TURN_OFF_REQUEST_CODE = 70
    }

    fun createAlarm() {
        alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, CloseServiceIntent::class.java)
        alarmIntent = PendingIntent.getService(context, TURN_OFF_REQUEST_CODE, intent, FLAG_UPDATE_CURRENT)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, 1)
        alarmManager!!.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, alarmIntent)
    }

}