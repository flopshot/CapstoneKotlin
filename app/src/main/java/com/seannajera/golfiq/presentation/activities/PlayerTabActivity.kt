package com.seannajera.golfiq.presentation.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.seannajera.golfiq.R
import com.seannajera.golfiq.presentation.fragments.PlayersFragment
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_tab_bar.*
import kotlinx.android.synthetic.main.tab_bar.*

class PlayerTabActivity : TabBarActivity(), HasSupportFragmentInjector {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v: View = layoutInflater.inflate(R.layout.activity_player_tab, null)
        tab_container.addView(v)

        if (savedInstanceState == null) navigateToFragment(PlayersFragment())
    }

    override fun fragmentContainerId(): Int {
        return R.id.player_tab_container
    }

    override fun onStart() {
        tabBar.menu.getItem(3).isChecked = true
        super.onStart()
    }
}
