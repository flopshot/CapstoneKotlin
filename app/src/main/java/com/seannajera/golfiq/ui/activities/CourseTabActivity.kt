package com.seannajera.golfiq.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.seannajera.golfiq.R
import com.seannajera.golfiq.ui.fragments.CoursesFragment
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_tab_bar.*
import kotlinx.android.synthetic.main.tab_bar.*

class CourseTabActivity : TabBarActivity(), HasSupportFragmentInjector {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v: View = layoutInflater.inflate(R.layout.activity_course_tab, null)
        tab_container.addView(v)

        if (savedInstanceState == null) navigateToFragment(CoursesFragment.TAG)
    }

    override fun fragmentContainerId(): Int {
        return R.id.course_tab_container
    }

    override fun onStart() {
        tabBar.menu.getItem(4).isChecked = true
        super.onStart()
    }
}
