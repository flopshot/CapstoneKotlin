package com.seannajera.golfiq.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seannajera.golfiq.R
import com.seannajera.golfiq.ui.adapters.CoursesAdapter
import kotlinx.android.synthetic.main.fragment_courses.*

class CoursesFragment : Fragment() {

    private lateinit var mParam1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments?.getString(ARG_PARAM1)?:""
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_courses, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = CoursesAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this.activity)
    }

    companion object {

        const val TAG = "COURSESFRAGMENT3"
        private const val ARG_PARAM1 = "param1"

        operator fun invoke(param1: String): CoursesFragment {
            val fragment = CoursesFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
