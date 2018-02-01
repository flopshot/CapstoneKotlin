package com.seannajera.golfiq.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.seannajera.golfiq.R
import com.seannajera.golfiq.injection.Injectable
import com.seannajera.golfiq.ui.activities.TabBarActivity
import kotlinx.android.synthetic.main.fragment_range_finder.*

class RangeFinderFragment : Fragment(), Injectable {

    private lateinit var mParam1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        if (arguments != null) {
            mParam1 = arguments?.getString(ARG_PARAM1) ?: ""
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_range_finder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newFragButton.setOnClickListener({ _ -> (activity as TabBarActivity).navigateToFragment(CoursesFragment.TAG)})
    }

    companion object {

        const val TAG = "RANGEFINDERFRAGMENT4"
        private const val ARG_PARAM1 = "param1"

        operator fun invoke(param1: String): RangeFinderFragment {
            val fragment = RangeFinderFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
