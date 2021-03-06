package com.seannajera.golfiq.presentation.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.seannajera.golfiq.R
import com.seannajera.golfiq.injection.Injectable

class OldRoundFragment : Fragment(), Injectable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_old_round, container, false)
    }

    companion object {
        const val TAG = "OLROUNDFRAGMENT1"
    }
}
