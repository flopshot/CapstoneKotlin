package com.seannajera.golfiq.presentation.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.transition.Fade
import com.seannajera.golfiq.GolfIqApplication
import com.seannajera.golfiq.R
import com.seannajera.golfiq.util.disableShiftMode
import kotlinx.android.synthetic.main.tab_bar.*
import javax.inject.Inject

abstract class TabBarActivity : BaseHasFragmentInjectorActivity(R.layout.activity_tab_bar) {

    @Inject
    lateinit var app: GolfIqApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tabBar.disableShiftMode()
        tabBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        overridePendingTransition(0,0)
        val fade = Fade()
        fade.excludeTarget(android.R.id.statusBarBackground, true)

        window.enterTransition = fade
        window.exitTransition = fade
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_new_round -> {
                navigateToTab(NewRoundTabActivity::class.java.name)
            }
            R.id.action_old_rounds -> {
                navigateToTab(OldRoundTabActivity::class.java.name)
            }
            R.id.action_range_finder -> {
                navigateToTab(RangeFinderTabActivity::class.java.name)
            }
            R.id.action_players -> {
                navigateToTab(PlayerTabActivity::class.java.name)
            }
            R.id.action_courses -> {
                navigateToTab(CourseTabActivity::class.java.name)
            }
        }
        false
    }

    fun navigateToTab(activityClassName: String) {
        val intent = Intent().apply {
            setClassName(this@TabBarActivity, activityClassName)
            flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        }

        if (activityClassName in app.activityCreatedList) {
            startActivity(intent)
        } else {
            val options = ActivityOptions
                    .makeSceneTransitionAnimation(this, tabBar, "tabBar")
            startActivity(intent
                    ,options.toBundle()
            )
        }
    }

    private fun commitChildFragmentTransaction(fragment: Fragment, fragmentTag: String) {
        supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(fragmentContainerId(), fragment, fragmentTag)
                .addToBackStack(fragmentTag)
                .commit()
    }

    fun navigateToFragment(fragment: Fragment, tag:String = "") {
        when (supportFragmentManager.backStackEntryCount) {
            0 -> commitChildFragmentTransaction(fragment, "first")
            else -> commitChildFragmentTransaction(fragment, tag)
        }
    }

    abstract fun fragmentContainerId(): Int

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            if (this !is NewRoundTabActivity) {
                navigateToTab(NewRoundTabActivity::class.java.name)
            } else {
                val a = Intent(Intent.ACTION_MAIN).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                    addCategory(Intent.CATEGORY_HOME)
                }
                startActivity(a)
            }
        }
    }
}
