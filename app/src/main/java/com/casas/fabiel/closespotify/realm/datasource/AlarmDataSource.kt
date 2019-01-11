package com.casas.fabiel.closespotify.realm.datasource

import android.arch.lifecycle.MutableLiveData
import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.domain.mapper.AlarmMapper
import com.casas.fabiel.closespotify.realm.RealmManager
import com.casas.fabiel.closespotify.realm.objects.AlarmRealmObject
import io.realm.Realm
import io.realm.RealmChangeListener


class AlarmDataSource {

    private var realm: Realm
    private val mapper = AlarmMapper()

    init {
        realm = RealmManager.getRealmInstance()
    }

    fun retrieveAlarmList(alarmItems: MutableLiveData<List<AlarmItem>>) {
        val result = realm.where(AlarmRealmObject::class.java).findAllAsync()
        result.let {
            alarmItems.value = mapper.transform(it)
        }
        result.addChangeListener(RealmChangeListener {
            alarmItems.value = mapper.transform(it)
        })
    }

    fun createNewAlarm(alarmItem: AlarmItem) {
        realm.executeTransactionAsync {
            val currentIdNum = it.where(AlarmRealmObject::class.java).max("id")
            val nextId = currentIdNum?.toInt()?.plus(1) ?: 1
            val alarmRealmObject = it.createObject(AlarmRealmObject::class.java)
            alarmRealmObject.id = nextId
            alarmRealmObject.alarmType = alarmItem.alarmType
            alarmRealmObject.expirationDate = alarmItem.expirationDate
            alarmRealmObject.textName = alarmItem.textName
            alarmRealmObject.timestamp = alarmItem.timestamp
            alarmRealmObject.repeat = alarmItem.repeat
            it.insertOrUpdate(alarmRealmObject)
        }
    }
}