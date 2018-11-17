package com.casas.fabiel.closespotify.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.ui.fragments.CountDownFragment
import com.casas.fabiel.closespotify.utils.base.BaseTimeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentFragment: BaseTimeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currentFragment = CountDownFragment()
        supportFragmentManager.beginTransaction().add(R.id.mainLayoutContainer, currentFragment).commit()
        initListeners()
    }

    private fun initListeners() {
        floatingActionButtonStart.setOnClickListener {
            startCalendarEvent()
        }
    }

    private fun startCalendarEvent() {
        currentFragment?.start()
    }
}
