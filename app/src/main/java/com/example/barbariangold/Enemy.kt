package com.example.barbariangold

import es.uji.jvilar.barbariangold.model.Direction
import es.uji.jvilar.barbariangold.model.Position
import es.uji.vj1229.framework.AnimatedBitmap

data class Enemy(var X: Float, var Y: Float, var position : Position ,
                 var lastPosition : Position, var speed : Int, var direction: Direction,
                 var sprite : AnimatedBitmap?) {
}