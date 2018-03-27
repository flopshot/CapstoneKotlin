package com.seannajera.golfiq.entities

data class Tees(var id: Int,
                var courseId: Int,
                var name: String,
                var color: String,
                var yards: Int,
                var rating: Float,
                var slope: Int)