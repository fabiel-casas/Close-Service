package com.casas.fabiel.closespotify.domain.mapper

import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.realm.objects.AlarmRealmObject

class AlarmMapper {

    fun transform(alarmRealmObject: AlarmRealmObject): AlarmItem {
        return AlarmItem(
                alarmRealmObject.textName,
                alarmRealmObject.repeat,
                alarmRealmObject.alarmType,
                alarmRealmObject.expirationDate,
                alarmRealmObject.timestamp
        )
    }

    fun transform(alarmList: List<AlarmRealmObject>): List<AlarmItem> = alarmList.map { transform(it) }
}