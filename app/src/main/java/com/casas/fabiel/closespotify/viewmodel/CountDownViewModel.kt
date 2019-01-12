package com.casas.fabiel.closespotify.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.CountDownTimer
import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.domain.AlarmTypes.COUNTDOWN
import com.casas.fabiel.closespotify.extensions.toHoursTime
import com.casas.fabiel.closespotify.extensions.toMinutesTime
import com.casas.fabiel.closespotify.extensions.toSecondsTime
import com.casas.fabiel.closespotify.extensions.toTimeUnits
import com.casas.fabiel.closespotify.realm.datasource.AlarmDataSource
import java.util.*

class CountDownViewModel : ViewModel() {
    lateinit var hours: MutableLiveData<String>
    lateinit var minute: MutableLiveData<String>
    lateinit var seconds: MutableLiveData<String>
    var alarmTimeMillis = 0L

    companion object {
        val TURN_OFF_REQUEST_CODE = 70
    }

    fun startAlarm(hourOfDay: Int, minute: Int) {
        setTimeToEndMillis(hourOfDay, minute)
        saveTimeInitAndEnd()
        startCountDownClock()
    }

    fun startCountDownClock() {
        val timerCount = alarmTimeMillis - Calendar.getInstance().timeInMillis
        object : CountDownTimer(timerCount, 500) {

            override fun onTick(millisUntilFinished: Long) {
                val hours = millisUntilFinished.toHoursTime()
                val minutes = millisUntilFinished.toMinutesTime()
                val second = millisUntilFinished.toSecondsTime()
                updateTimerText(hours, minutes, second)
            }

            override fun onFinish() {
                updateTimerText(0, 0, 0)
            }
        }.start()
    }

    private fun updateTimerText(hourOfDay: Int, minu: Int, sec: Int) {
        hours.value = hourOfDay.toTimeUnits()
        minute.value = minu.toTimeUnits()
        seconds.value = sec.toTimeUnits()
    }

    private fun setTimeToEndMillis(hourOfDay: Int, minute: Int) {
        val alarmTime = Calendar.getInstance()
        alarmTime.add(Calendar.HOUR, hourOfDay)
        alarmTime.add(Calendar.MINUTE, minute)
        alarmTimeMillis = alarmTime.timeInMillis
    }

    private fun saveTimeInitAndEnd() {
        val alarm = AlarmItem("Test 1", false, COUNTDOWN, alarmTimeMillis, Calendar.getInstance().timeInMillis)
        AlarmDataSource().createNewAlarm(alarm)
    }

    fun getHours(): LiveData<String> {
        if (!::hours.isInitialized) {
            hours = MutableLiveData()
        }
        return hours
    }

    fun getMinutes(): LiveData<String> {
        if (!::minute.isInitialized) {
            minute = MutableLiveData()
        }
        return minute
    }

    fun getSeconds(): LiveData<String> {
        if (!::seconds.isInitialized) {
            seconds = MutableLiveData()
        }
        return seconds
    }

}