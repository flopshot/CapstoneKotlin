package com.seannajera.golfiq.entities

import java.util.*

data class Course(var id: Int,
                  var clubId: Int,
                  var courseName: String,
                  var par: Int = 72,
                  var createdAt: Date = Date(),
                  var updatedAt: Date = Date())