package com.casas.fabiel.closespotify.app

import android.app.Application
import com.casas.fabiel.closespotify.realm.RealmManager

class AlarmApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        RealmManager.init(this)
    }
}