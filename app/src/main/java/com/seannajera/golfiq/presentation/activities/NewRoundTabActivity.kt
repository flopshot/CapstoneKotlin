package com.seannajera.golfiq.presentation.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.seannajera.golfiq.R
import com.seannajera.golfiq.presentation.fragments.PlayGolfFragment
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_tab_bar.*
import kotlinx.android.synthetic.main.tab_bar.*

class NewRoundTabActivity : TabBarActivity(), HasSupportFragmentInjector {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v: View = layoutInflater.inflate(R.layout.activity_new_round_tab, null)
        tab_container.addView(v)

        if (savedInstanceState == null) navigateToFragment(PlayGolfFragment())
    }

    override fun fragmentContainerId(): Int {
        return R.id.new_round_tab_container
    }

    override fun onStart() {
        tabBar.menu.getItem(0).isChecked = true
        super.onStart()
    }
}
