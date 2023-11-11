package com.example.barbariangold.view

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import com.example.barbariangold.Assets
import com.example.barbariangold.controller.BarbarianGoldController
import com.example.barbariangold.model.BarbarianGoldModel
import es.uji.jvilar.barbariangold.model.CellType
import es.uji.jvilar.barbariangold.model.Direction
import es.uji.vj1229.framework.GameActivity
import es.uji.vj1229.framework.Graphics

class BarbarianGoldActivity : GameActivity(), IBarbarianGoldenView {

    companion object{
        private const val BACKGROUND_COLOR = Color.BLACK
        private const val GOLD_COLOR = Color.YELLOW
        private const val INFO_SIZE = 60
    }

    private var width = 0
    private var height = 0

    private var scale = 0
    private var offsetX = 0
    private var offsetY = 0

    private lateinit var graphics: Graphics
    private val model = BarbarianGoldModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        landscapeFullScreenOnCreate()
    }

    override fun returnWidth(): Int {
        return  width
    }

    override fun returnHeight(): Int {
        return  height
    }

    override fun buildGameController() = BarbarianGoldController(this, model)


    override fun onBitmapMeasuresAvailable(width: Int, height: Int) {

        if(this.width == width && this.height == height) return

        this.width = width
        this.height = height

        val scaleX = width / model.numCols
        val scaleY = (height - INFO_SIZE * 2) / model.numRows

        scale = Math.min(scaleX, scaleY)

        offsetX = (width - (scale * model.numCols))/2
        offsetY = (height - (scale * model.numRows) - INFO_SIZE)/2

        Assets.createAssets(this, scale)
        graphics =  Graphics(width, height)
    }


    override fun onDrawingRequested(): Bitmap? {
        if(width == 0) return null
        graphics.clear(BACKGROUND_COLOR)
        drawMaze()
        drawGold()
        drawPotions()
        drawEnemies()
        drawPrincess()
        drawInformation()
        return graphics.frameBuffer
    }


    private fun drawMaze(){
        for(row in 0 until model.numRows)
            for(col in 0 until model.numCols){
                if (model.maze[row, col].type == CellType.WALL){
                    var bitmap = Assets.verticalWall
                    if(model.maze[row,col].hasWall(Direction.UP)){
                        if(model.maze[row,col].hasWall(Direction.RIGHT)){
                            if(model.maze[row,col].hasWall(Direction.DOWN)){
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.verticalHorizontalWall
                                }else{
                                    bitmap =  Assets.verticalRightWall
                                }
                            }else{
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.horizontalUpWall
                                }else{
                                    bitmap =  Assets.upRightWall
                                }
                            }
                        }else{
                            if(model.maze[row,col].hasWall(Direction.DOWN)){
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.verticalLeftWall
                                }else{
                                    bitmap =  Assets.verticalWall
                                }
                            }else{
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.upLeftWall
                                }else{
                                    bitmap =  Assets.endDownWall
                                }
                            }
                        }
                    }
                    else{
                        if(model.maze[row,col].hasWall(Direction.RIGHT)){
                            if(model.maze[row,col].hasWall(Direction.DOWN)){
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.horizontalDownWall
                                }else{
                                    bitmap =  Assets.downRightWall
                                }
                            }else{
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.horizontalWall
                                }else{
                                    bitmap =  Assets.endLeftWall
                                }
                            }
                        }else{
                            if(model.maze[row,col].hasWall(Direction.DOWN)){
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.downLeftWall
                                }else{
                                    bitmap =  Assets.endUpWall
                                }
                            }else{
                                if(model.maze[row,col].hasWall(Direction.LEFT)){
                                    bitmap = Assets.endRightWall
                                }
                            }
                        }
                    }
                    graphics.drawBitmap(bitmap, col * scale.toFloat() + offsetX, row * scale.toFloat() + offsetY)
                }
            }
    }


    private fun drawGold(){
        for(row in 0 until model.numRows)
            for(col in 0 until model.numCols){
                if(model.maze[row, col].type == CellType.GOLD && !model.maze[row, col].used){
                    graphics.drawCircle((col+0.5f) * scale.toFloat() + offsetX, (row+0.5f) * scale.toFloat() + offsetY, scale/6f, GOLD_COLOR)
                }
            }
    }


    private fun drawPotions(){
        for(row in 0 until model.numRows)
            for(col in 0 until model.numCols){
                if(model.maze[row, col].type == CellType.POTION && !model.maze[row, col].used){
                    graphics.drawBitmap(Assets.potion, col * scale.toFloat() + offsetX, row * scale.toFloat() + offsetY)
                }
            }
    }


    private fun drawEnemies(){
        var numEnemy  = 0
        for(row in 0 until model.numRows)
            for(col in 0 until model.numCols){
                if(model.maze[row, col].type == CellType.HOME){
                    if (numEnemy == 0){
                        val bitmap = model.enemies[numEnemy].sprite?.currentFrame
                        graphics.drawBitmap(bitmap, (model.enemies[numEnemy].X - 0.5f) * scale.toFloat() + offsetX, (model.enemies[numEnemy].Y - 0.5f) * scale.toFloat() + offsetY)
                        numEnemy ++
                    }
                    else if (numEnemy == 1){
                        val bitmap = model.enemies[numEnemy].sprite?.currentFrame
                        graphics.drawBitmap(bitmap, (model.enemies[numEnemy].X - 0.5f) * scale.toFloat() + offsetX, (model.enemies[numEnemy].Y - 0.5f) * scale.toFloat() + offsetY)
                        numEnemy ++
                    }
                    else if (numEnemy == 2){
                        val bitmap = model.enemies[numEnemy].sprite?.currentFrame
                        graphics.drawBitmap(bitmap, (model.enemies[numEnemy].X - 0.5f) * scale.toFloat() + offsetX, (model.enemies[numEnemy].Y - 0.5f) * scale.toFloat() + offsetY)
                        numEnemy ++
                    }
                    else if (numEnemy >= 3){
                        val bitmap = model.enemies[numEnemy].sprite?.currentFrame
                        graphics.drawBitmap(bitmap, (model.enemies[numEnemy].X - 0.5f) * scale.toFloat() + offsetX, (model.enemies[numEnemy].Y - 0.5f) * scale.toFloat() + offsetY)
                        numEnemy ++
                    }
                }
            }
    }


    private fun drawPrincess(){
        for(row in 0 until model.numRows)
            for(col in 0 until model.numCols){
                if(model.maze[row, col].type == CellType.ORIGIN){
                    val bitmap = model.princessSprite?.currentFrame
                    if(bitmap != null){
                        graphics.drawBitmap(bitmap, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                    }
                    else {
                        if(!model.takesPotion){
                            when (model.princessDirection) {
                                Direction.RIGHT -> graphics.drawBitmap(Assets.princessStopRight, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                                Direction.LEFT -> graphics.drawBitmap(Assets.princessStopLeft, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                                Direction.UP -> graphics.drawBitmap(Assets.princessStopBack, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                                Direction.DOWN -> graphics.drawBitmap(Assets.princessStopFront, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                            }
                        }
                        else{
                            when (model.princessDirection) {
                                Direction.RIGHT -> graphics.drawBitmap(Assets.princessPotionStopRight, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                                Direction.LEFT -> graphics.drawBitmap(Assets.princessPotionStopLeft, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                                Direction.UP -> graphics.drawBitmap(Assets.princessPotionStopBack, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                                Direction.DOWN -> graphics.drawBitmap(Assets.princessPotionStopFront, (model.princessX - 0.5f) * scale + offsetX, (model.princessY - 0.5f) * scale + offsetY)
                            }
                        }
                    }
                }
            }
    }


    private fun drawInformation(){
        //SCORE TEXT
        graphics.setTextSize(INFO_SIZE)
        graphics.setTextColor(Color.WHITE)
        graphics.setTextAlign(Paint.Align.LEFT)
        graphics.drawText(offsetX.toFloat(), (height - offsetY).toFloat(), "Score: " + model.score)

        //LIVES
        for(i in 0 until model.lives){
            graphics.drawBitmap(Assets.princessStopFront, (width - offsetX - scale - (scale * i)).toFloat(), (height - offsetY * 2).toFloat())
        }

        //GAME OVER TEXT
        if(model.gameover)
        {
            graphics.drawRect((width/4).toFloat(), (height/4).toFloat(), (width/2).toFloat(), (height/2).toFloat(), Color.WHITE)

            graphics.setTextSize(scale * 2)
            graphics.setTextColor(Color.RED)
            graphics.setTextAlign(Paint.Align.CENTER)
            graphics.drawText((width/2).toFloat(), (3 * height/7).toFloat(), "GAME OVER")

            graphics.setTextSize(scale)
            graphics.setTextColor(Color.BLACK)
            graphics.setTextAlign(Paint.Align.CENTER)
            graphics.drawText((width/2).toFloat(), (4 * height/7).toFloat(), "PRESS TO START")
        }

    }

    override fun update(deltaTime: Float) {
        //UPDATE PRINCESS
        model.princessSprite?.update(deltaTime)
        if(!model.dead){
            if(!model.takesPotion){
                if(model.isMoving){
                    model.princessSprite = when (model.princessDirection) {
                        Direction.RIGHT -> Assets.princessWalkRight
                        Direction.LEFT -> Assets.princessWalkLeft
                        Direction.UP -> Assets.princessWalkBack
                        Direction.DOWN -> Assets.princessWalkFront
                    }
                }else{
                    model.princessSprite = null
                }
            }else{
                if(model.isMoving){
                    model.princessSprite = when (model.princessDirection) {
                        Direction.RIGHT -> Assets.princessPotionWalkRight
                        Direction.LEFT -> Assets.princessPotionWalkLeft
                        Direction.UP -> Assets.princessPotionWalkBack
                        Direction.DOWN -> Assets.princessPotionWalkFront
                    }
                }else{
                    model.princessSprite = null
                }
            }
        }else{
            model.princessSprite = Assets.princessDead
        }

        //UPDATE ENEMIES
        for (i in 0 until model.enemies.size){
            when (i) {
                0 -> {
                    model.enemies[i].sprite?.update(deltaTime)
                    model.enemies[i].sprite = when (model.enemies[i].direction) {
                        Direction.RIGHT -> Assets.enemy1Right
                        Direction.LEFT -> Assets.enemy1Left
                        Direction.UP -> Assets.enemy1Back
                        Direction.DOWN -> Assets.enemy1Front
                    }
                }
                1 -> {
                    model.enemies[i].sprite?.update(deltaTime)
                    model.enemies[i].sprite = when (model.enemies[i].direction) {
                        Direction.RIGHT -> Assets.enemy2Right
                        Direction.LEFT -> Assets.enemy2Left
                        Direction.UP -> Assets.enemy2Back
                        Direction.DOWN -> Assets.enemy2Front
                    }
                }
                2 -> {
                    model.enemies[i].sprite?.update(deltaTime)
                    model.enemies[i].sprite = when (model.enemies[i].direction) {
                        Direction.RIGHT -> Assets.enemy3Right
                        Direction.LEFT -> Assets.enemy3Left
                        Direction.UP -> Assets.enemy3Back
                        Direction.DOWN -> Assets.enemy3Front
                    }
                }
                3 -> {
                    model.enemies[i].sprite?.update(deltaTime)
                    model.enemies[i].sprite = when (model.enemies[i].direction) {
                        Direction.RIGHT -> Assets.enemy4Right
                        Direction.LEFT -> Assets.enemy4Left
                        Direction.UP -> Assets.enemy4Back
                        Direction.DOWN -> Assets.enemy4Front
                    }
                }
            }
        }
    }
}

