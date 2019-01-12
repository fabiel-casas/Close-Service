package com.casas.fabiel.closespotify.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.domain.ActivityKeys.KEY_COUNTDOWN
import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.domain.AlarmTypes.COUNTDOWN
import com.casas.fabiel.closespotify.ui.adapters.AlarmAdapter
import com.casas.fabiel.closespotify.viewmodel.MainListViewModel
import kotlinx.android.synthetic.main.activity_main_list.*

class MainListActivity : AppCompatActivity() {

    private lateinit var viewModel: MainListViewModel
    private lateinit var adapter: AlarmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)
        viewModel = ViewModelProviders.of(this).get(MainListViewModel::class.java)
        initAdapter()
        initObservers()
    }


    private fun initAdapter() {
        adapter = AlarmAdapter(mutableListOf(), {
            startAlarmDetailFlow(it)
        })
        alarmRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        alarmRecyclerView.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))
        alarmRecyclerView.adapter = adapter
    }

    private fun startAlarmDetailFlow(alarm: AlarmItem) {
        when (alarm.alarmType) {
            COUNTDOWN -> startCountDownActivity(alarm)
            else -> starRadioAlarmCountDown(alarm)
        }
    }

    private fun starRadioAlarmCountDown(alarm: AlarmItem) {

    }

    private fun startCountDownActivity(alarm: AlarmItem) {
        val intent = Intent(this, CountDownActivity::class.java)
        intent.putExtra(KEY_COUNTDOWN, alarm)
        this.startActivity(intent)
    }

    private fun initObservers() {
        viewModel.alarmItems.observe(this, Observer {
            updateItemList(it)
        })
    }

    private fun updateItemList(alarmList: List<AlarmItem>?) {
        alarmList.let {
            adapter.items = it!!
        }
    }
}
