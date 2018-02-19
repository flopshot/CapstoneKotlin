package com.seannajera.golfiq.presentation.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.seannajera.golfiq.R
import com.seannajera.golfiq.presentation.fragments.OldRoundFragment
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_tab_bar.*
import kotlinx.android.synthetic.main.tab_bar.*

class OldRoundTabActivity : TabBarActivity(), HasSupportFragmentInjector {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v: View = layoutInflater.inflate(R.layout.activity_old_round_tab, null)
        tab_container.addView(v)

        if (savedInstanceState == null) navigateToFragment(OldRoundFragment())
    }

    override fun fragmentContainerId(): Int {
        return R.id.old_round_tab_container
    }

    override fun onStart() {
        tabBar.menu.getItem(1).isChecked = true
        super.onStart()
    }
}
