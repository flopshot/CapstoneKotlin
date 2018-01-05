package com.seannajera.golfiq

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView

@SuppressLint("RestrictedApi")
fun BottomNavigationView.disableShiftMode() {
    val menuView = this.getChildAt(0) as BottomNavigationMenuView

    try {
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menuView, false)
        shiftingMode.isAccessible = false
        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView

            item.setShiftingMode(false)
            // set once again checked value, so view will be updated

            item.setChecked(item.itemData.isChecked)
        }
    } catch (e: NoSuchFieldException) {
        Log.e("BNVHelper", "Unable to get shift mode field", e)
    } catch (e: IllegalAccessException) {
        Log.e("BNVHelper", "Unable to change value of shift mode", e)
    }
}

fun BottomNavigationView.addBadge(tabIndex: Int, count:Int) {
    val menuView = this.getChildAt(0) as BottomNavigationMenuView
    val itemView = menuView.getChildAt(tabIndex) as BottomNavigationItemView

    val badge = LayoutInflater.from(GolfIqApplication.get())
            .inflate(R.layout.notification_badge, menuView, false)

    val countText:TextView = badge.findViewById(R.id.badge_text)
    countText.text = if (count < 9) count.toString() else "+9"
    itemView.addView(badge)
}