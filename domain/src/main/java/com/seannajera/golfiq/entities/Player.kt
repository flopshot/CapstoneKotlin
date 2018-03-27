package com.seannajera.golfiq.entities

import java.util.*

data class Player(var id: Int,
                  var firstName: String,
                  var lastName: String,
                  var handicap: Int = 0,
                  var createdAt: Date = Date(),
                  var updatedAt: Date = Date())