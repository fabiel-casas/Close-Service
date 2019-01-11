package com.casas.fabiel.closespotify.realm

import android.content.Context
import io.realm.Realm

object RealmManager {

    fun init(context: Context) {
        Realm.init(context)
    }

    fun getRealmInstance(): Realm {
        return Realm.getDefaultInstance()
    }

}