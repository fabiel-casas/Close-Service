package com.casas.fabiel.closespotify.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.viewmodel.MainListViewModel

class MainListActivity : AppCompatActivity() {

    private lateinit var viewModel: MainListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)
        viewModel = ViewModelProviders.of(this).get(MainListViewModel::class.java)
        initAdapter()
        initObservers()
    }

    private fun initAdapter() {

    }

    private fun initObservers() {
        viewModel.alarmItems.observe(this, Observer {
            updateItemList(it)
        })
    }

    private fun updateItemList(alarmList: List<AlarmItem>?) {

    }
}
