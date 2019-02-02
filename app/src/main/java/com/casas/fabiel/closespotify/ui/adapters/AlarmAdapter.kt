package com.casas.fabiel.closespotify.ui.adapters

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.domain.AlarmItem
import com.casas.fabiel.closespotify.extensions.toLegibleDate
import kotlinx.android.synthetic.main.item_alarm.view.*

class AlarmAdapter(var items: List<AlarmItem>, var listener: (alarmItem: AlarmItem) -> Unit) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm, parent, false)
        return AlarmViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    /**
     * Adaptador de la lista de alarma que neces un @itemView para funciona
     * @itemView es una vista previamente inflada que tiene 2 campos.
     */
    inner class AlarmViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(alarmItem: AlarmItem) {
            itemView.setOnClickListener {
                listener.invoke(alarmItem)
            }
            itemView.textViewTimeAlarm.text = alarmItem.expirationDate.toLegibleDate()
            itemView.textViewRadioStation.text = alarmItem.textName
            if (alarmItem.repeat) {
                itemView.textViewBluetoothEnabler.text = "ON"
                itemView.textViewBluetoothEnabler.setTextColor(ContextCompat.getColor(itemView.context, R.color.green))
            } else {
                itemView.textViewBluetoothEnabler.text = "OFF"
                itemView.textViewBluetoothEnabler.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
            }
        }
    }
}