package com.casas.fabiel.closespotify.domain

data class AlarmItem(
        var textName: String = "",
        var repeat: Boolean = false,
        var alarmType: String = "",
        var expirationDate: Long = 0,
        var timestamp: Long = 0
)