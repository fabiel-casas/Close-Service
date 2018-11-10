package com.casas.fabiel.closespotify.services

import android.app.IntentService
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.widget.Toast


class CloseServiceIntent: IntentService(CloseServiceIntent::class.simpleName) {


    override fun onHandleIntent(intent: Intent?) {
        turnOffBluetooth()
    }

    private fun turnOffBluetooth() {
        Toast.makeText(applicationContext, "Yeah!!!!", Toast.LENGTH_LONG).show()
        val mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (mBluetoothAdapter.isEnabled) {
            print("Success!!!!")
            mBluetoothAdapter.disable()
        }
    }

}