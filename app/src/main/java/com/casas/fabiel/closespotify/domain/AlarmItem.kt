package com.casas.fabiel.closespotify.domain

import com.casas.fabiel.closespotify.domain.AlarmTypes.COUNTDOWN
import java.io.Serializable

data class AlarmItem(
        var textName: String = "",
        var repeat: Boolean = false,
        var alarmType: String = COUNTDOWN,
        var expirationDate: Long = 0,
        var timestamp: Long = 0
) : Serializable