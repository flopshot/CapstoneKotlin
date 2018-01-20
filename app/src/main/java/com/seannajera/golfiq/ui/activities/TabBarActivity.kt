package com.seannajera.golfiq.ui.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.seannajera.golfiq.R
import com.seannajera.golfiq.disableShiftMode
import com.seannajera.golfiq.ui.fragments.*
import kotlinx.android.synthetic.main.tab_bar.*

class TabBarActivity : BaseHasFragmentInjectorActivity(R.layout.activity_tab_bar) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tabBar.disableShiftMode()
        tabBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) navigateToTab(PlayGolfFragment.TAG)
//        tabBar.addBadge(1,8, golfIqApplication)         //Todo: Just an Example
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_new_round -> {
                navigateToTab(PlayGolfFragment.TAG)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_old_rounds -> {
                navigateToTab(OldRoundFragment.TAG)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_players -> {
                navigateToTab(PlayersFragment.TAG)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_courses -> {
                navigateToTab(CoursesFragment.TAG)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_range_finder -> {
                navigateToTab(RangeFinderFragment.TAG)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun navigateToTab(fragmentTag: String) {

        val topTag = peekAtFragmentStackTag()

        if (topTag == fragmentTag) return

        val fragmentManager = supportFragmentManager
        val inStackFragment = fragmentManager.findFragmentByTag(fragmentTag)
        val transaction = fragmentManager.beginTransaction()


        if (inStackFragment != null) {
            transactionWithAnimation(transaction, inStackFragment, topTag, fragmentTag)
        } else {
            when (fragmentTag) {
                PlayGolfFragment.TAG -> transactionWithAnimation(
                        transaction, PlayGolfFragment.newInstance("duh"), topTag, fragmentTag
                )
                OldRoundFragment.TAG -> transactionWithAnimation(
                        transaction, OldRoundFragment.newInstance("duh"), topTag, fragmentTag
                )
                PlayersFragment.TAG -> transactionWithAnimation(
                        transaction, PlayersFragment.newInstance("duh"), topTag, fragmentTag
                )
                CoursesFragment.TAG -> transactionWithAnimation(
                        transaction, CoursesFragment.newInstance("duh"), topTag, fragmentTag
                )
                RangeFinderFragment.TAG -> transactionWithAnimation(
                        transaction, RangeFinderFragment.newInstance("duh"), topTag, fragmentTag
                )
            }
        }
    }

    private fun peekAtFragmentStackTag(): String {
        val index = supportFragmentManager.backStackEntryCount - 1

        return when (index) {
            !in 0.downTo(-1) -> supportFragmentManager.getBackStackEntryAt(index).name
            else -> "0"
        }
    }

    private fun transactionWithAnimation(transaction: FragmentTransaction, fragment: Fragment,
                                         fromTabTag: String, toTabTag: String) {

        val fromTabIndex = fromTabTag[fromTabTag.length - 1].toInt()
        val toTabIndex = toTabTag[toTabTag.length - 1].toInt()

        if (toTabIndex < fromTabIndex) {
            transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
        } else {
            transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        transaction.replace(R.id.fragment_container, fragment)
                .addToBackStack(toTabTag)
                .commit()
    }
}
