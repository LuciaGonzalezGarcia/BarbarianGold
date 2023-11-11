package com.example.barbariangold.controller

import com.example.barbariangold.model.BarbarianGoldModel
import com.example.barbariangold.view.IBarbarianGoldenView
import es.uji.jvilar.barbariangold.controller.GestureDetector
import es.uji.jvilar.barbariangold.model.Direction
import es.uji.vj1229.framework.IGameController
import es.uji.vj1229.framework.TouchHandler

class BarbarianGoldController(private val view : IBarbarianGoldenView, private val model : BarbarianGoldModel) : IGameController{

    private val gesture = GestureDetector()
    var direction : Direction? = null

    override fun onUpdate(deltaTime: Float, touchEvents: MutableList<TouchHandler.TouchEvent>) {

        for (event in touchEvents) {
            if (event.type == TouchHandler.TouchType.TOUCH_DOWN) {
                gesture.onTouchDown(event.x/view.returnWidth().toFloat(), event.y/view.returnHeight().toFloat())
            }

            else if (event.type == TouchHandler.TouchType.TOUCH_UP) {
                val gest : GestureDetector.Gestures = gesture.onTouchUp(event.x/view.returnWidth().toFloat(), event.y/view.returnHeight().toFloat())
                if(gest == GestureDetector.Gestures.SWIPE){
                    direction = gesture.direction
                    model.updatePrincessDirection(direction)
                }
                else if (gest == GestureDetector.Gestures.CLICK){
                    if (model.gameover){
                        if ((view.returnWidth()/4 <= event.x && event.x <= 3 * view.returnWidth()/4) && (view.returnHeight()/4 <= event.y && event.y <= 3 * view.returnHeight()/4)){
                            model.gameOver()
                        }
                    }
                }
            }
        }
        view.update(deltaTime)
        model.update(deltaTime)
    }
}