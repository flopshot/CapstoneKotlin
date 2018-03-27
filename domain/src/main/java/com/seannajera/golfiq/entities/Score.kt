package com.seannajera.golfiq.entities

data class Score(var id: Int,
                 var holeId: Int,
                 var roundId: Int,
                 var playerId: Int,
                 var strokes: Int,
                 var penalties: Int,
                 var putts: Int,
                 var sandShots: Int,
                 var girFlag: Int,
                 var firFlag: Int)