package com.casas.fabiel.closespotify.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.ui.fragments.CountDownFragment
import com.casas.fabiel.closespotify.utils.base.BaseTimeFragment
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {

    var currentFragment: BaseTimeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        currentFragment = CountDownFragment()
        currentFragment?.arguments = intent.extras
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
