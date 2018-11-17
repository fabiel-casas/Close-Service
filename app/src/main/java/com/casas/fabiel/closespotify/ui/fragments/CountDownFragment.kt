package com.casas.fabiel.closespotify.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.utils.base.BaseTimeFragment
import com.casas.fabiel.closespotify.viewmodel.CountDownViewModel

class CountDownFragment : BaseTimeFragment() {

    var viewModel: CountDownViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = CountDownViewModel(context!!)
        return inflater.inflate(R.layout.fragment_count_down, container, false)
    }

    override fun start() {
        viewModel?.createAlarm()
    }

}
