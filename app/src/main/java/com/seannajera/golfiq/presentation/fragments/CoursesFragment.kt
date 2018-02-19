package com.seannajera.golfiq.presentation.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seannajera.golfiq.R
import com.seannajera.golfiq.injection.Injectable

class CoursesFragment : Fragment(), Injectable {

    private lateinit var mParam1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_courses, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        recyclerView.adapter = CoursesAdapter()
//        recyclerView.layoutManager = LinearLayoutManager(this.activity) TODO
    }

    companion object {
        const val TAG = "COURSESFRAGMENT3"
    }
}
