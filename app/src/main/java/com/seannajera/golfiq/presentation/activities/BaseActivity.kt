package com.seannajera.golfiq.presentation.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


abstract class BaseActivity(private var layoutId: Int):AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}