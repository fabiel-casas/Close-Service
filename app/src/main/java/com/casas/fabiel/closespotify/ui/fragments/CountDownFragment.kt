package com.casas.fabiel.closespotify.ui.fragments


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.casas.fabiel.closespotify.R
import com.casas.fabiel.closespotify.utils.base.BaseTimeFragment
import com.casas.fabiel.closespotify.viewmodel.CountDownViewModel
import kotlinx.android.synthetic.main.fragment_count_down.*

class CountDownFragment : BaseTimeFragment() {

    var viewModel: CountDownViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = CountDownViewModel(context!!)
        initCountDownText()
        return inflater.inflate(R.layout.fragment_count_down, container, false)
    }

    override fun start() {
        viewModel?.setTimer()
    }

    private fun initCountDownText() {
        viewModel?.getHours()?.observe(this, Observer<String>{ hourText ->
            textViewTimeCountdownHours.text = hourText
        })
        viewModel?.getMinuites()?.observe(this, Observer<String>{ hourText ->
            textViewTimeCountdownMinutes.text = hourText
        })

        viewModel?.getSeconds()?.observe(this, Observer<String>{ hourText ->
            textViewTimeCountdownSeconds.text = hourText
        })
    }

}
