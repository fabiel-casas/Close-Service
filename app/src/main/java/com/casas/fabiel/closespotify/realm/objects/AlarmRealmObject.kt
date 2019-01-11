package com.casas.fabiel.closespotify.realm.objects

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class AlarmRealmObject : RealmModel {
    @PrimaryKey
    var id:Int = 0
    var textName: String = ""
    var repeat: Boolean = false
    var alarmType: String = ""
    var expirationDate: Long = 0
    var timestamp: Long = 0
}