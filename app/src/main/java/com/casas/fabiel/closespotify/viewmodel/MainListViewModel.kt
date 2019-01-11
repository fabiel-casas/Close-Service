package com.casas.fabiel.closespotify.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.realm.datasource.AlarmDataSource

class MainListViewModel: ViewModel() {

    val alarmItems: MutableLiveData<List<AlarmItem>>
    private var dataSource: AlarmDataSource

    init {
        dataSource = AlarmDataSource()
        alarmItems = MutableLiveData()
        dataSource.retrieveAlarmList(alarmItems)
    }
}