package com.casas.fabiel.closespotify.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = MainViewModel(this)
        initListeners()
    }

    private fun initListeners() {
        buttonStartCountDown.setOnClickListener {
            startCalendarEvent()
        }
    }

    private fun startCalendarEvent() {
        viewModel?.createAlarm()
    }
}
