package com.seannajera.golfiq.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.seannajera.golfiq.R
import com.seannajera.golfiq.ui.fragments.RangeFinderFragment
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_tab_bar.*
import kotlinx.android.synthetic.main.tab_bar.*

class RangeFinderTabActivity : TabBarActivity(), HasSupportFragmentInjector {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v: View = layoutInflater.inflate(R.layout.activity_range_finder_tab, null)
        tab_container.addView(v)

        if (savedInstanceState == null) navigateToFragment(RangeFinderFragment.TAG)
    }

    override fun fragmentContainerId(): Int {
        return R.id.range_finder_container
    }

    override fun onStart() {
        tabBar.menu.getItem(2).isChecked = true
        super.onStart()
    }
}
