package com.seannajera.golfiq.entities

data class Hole(var id: Int,
                var teeId: Int,
                var number: Int,
                var yards: Int,
                var par: Int,
                var handicap: Int)