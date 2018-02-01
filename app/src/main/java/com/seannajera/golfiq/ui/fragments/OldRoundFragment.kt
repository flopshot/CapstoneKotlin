package com.seannajera.golfiq.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.seannajera.golfiq.R
import com.seannajera.golfiq.injection.Injectable

class OldRoundFragment : Fragment(), Injectable {

    private lateinit var mParam1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments?.getString(ARG_PARAM1)?:""
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_old_round, container, false)
    }

    companion object {

        const val TAG = "OLROUNDFRAGMENT1"
        private const val ARG_PARAM1 = "param1"

        operator fun invoke(param1: String): OldRoundFragment {
            val fragment = OldRoundFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
