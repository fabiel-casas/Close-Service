package com.casas.fabiel.closespotify.ui.fragments


import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.domain.ActivityKeys.KEY_COUNTDOWN
import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.services.CloseServiceIntent
import com.casas.fabiel.closespotify.utils.base.BaseTimeFragment
import com.casas.fabiel.closespotify.viewmodel.CountDownViewModel
import kotlinx.android.synthetic.main.fragment_count_down.*

class CountDownFragment : BaseTimeFragment() {

    var viewModel: CountDownViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(CountDownViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        initCountDownText()
        setInitialValues()
        return inflater.inflate(R.layout.fragment_count_down, container, false)
    }

    private fun setInitialValues() {
        val alarm = arguments?.getSerializable(KEY_COUNTDOWN) as AlarmItem
        alarm.let {
            viewModel?.alarmTimeMillis = it.expirationDate
            viewModel?.startCountDownClock()
        }
    }

    private fun initCountDownText() {
        viewModel?.getHours()?.observe(this, Observer<String>{ hourText ->
            textViewTimeCountdownHours.text = hourText
        })
        viewModel?.getMinutes()?.observe(this, Observer<String>{ hourText ->
            textViewTimeCountdownMinutes.text = hourText
        })

        viewModel?.getSeconds()?.observe(this, Observer<String>{ hourText ->
            textViewTimeCountdownSeconds.text = hourText
        })
    }

    override fun start() {
        val timeDialog = TimePickerDialog(context,
        TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute -> startAlarm(hourOfDay, minute) },
                0, 0, true)
        timeDialog.show()
    }

    private fun startAlarm(hourOfDay: Int, minute: Int) {
        viewModel?.startAlarm(hourOfDay, minute)
        scheduleIntentAlarm()
    }

    private fun scheduleIntentAlarm() {
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, CloseServiceIntent::class.java)
        val alarmIntent = PendingIntent.getService(context, CountDownViewModel.TURN_OFF_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager.set(AlarmManager.RTC_WAKEUP, viewModel?.alarmTimeMillis!!, alarmIntent)
    }
}
