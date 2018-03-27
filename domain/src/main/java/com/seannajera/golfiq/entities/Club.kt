package com.seannajera.golfiq.entities

import java.util.*

data class Club(var id: Int,
                var clubName: String,
                var telephoneNumber: String,
                var address: String,
                var createdAt: Date = Date(),
                var updatedAt: Date = Date())