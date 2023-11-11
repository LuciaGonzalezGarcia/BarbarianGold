package com.example.barbariangold

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import es.uji.vj1229.framework.AnimatedBitmap
import es.uji.vj1229.framework.SpriteSheet

object Assets {

    private const val SPRITE_WALL_SIDE = 32
    private const val VERTICAL_WALL_INDEX = 0
    private const val HORIZONTAL_WALL_INDEX = 1
    private const val VERTICAL_HORIZONTAL_WALL_INDEX = 2
    private const val VERTICAL_LEFT_WALL_INDEX = 3
    private const val HORIZONTAL_DOWN_WALL_INDEX = 4
    private const val VERTICAL_RIGHT_WALL_INDEX = 5
    private const val HORIZONTAL_UP_WALL_INDEX = 6
    private const val UP_RIGHT_WALL_INDEX = 7
    private const val UP_LEFT_WALL_INDEX = 8
    private const val DOWN_LEFT_WALL_INDEX = 9
    private const val DOWN_RIGHT_WALL_INDEX = 10
    private const val END_LEFT_WALL_INDEX = 11
    private const val END_UP_WALL_INDEX = 12
    private const val END_RIGHT_WALL_INDEX = 13
    private const val END_DOWN_WALL_INDEX = 14

    private const val WALK_FRAMES = 9
    private const val DEAD_FRAMES = 6
    private const val CHARACTERS_SIDE = 64
    private const val BACK_INDEX = 8
    private const val LEFT_INDEX = 9
    private const val FRONT_INDEX = 10
    private const val RIGHT_INDEX = 11
    private const val DEAD_INDEX = 20

    var princessStopFront: Bitmap? = null
    var princessStopBack: Bitmap? = null
    var princessStopRight: Bitmap? = null
    var princessStopLeft: Bitmap? = null
    var princessWalkFront: AnimatedBitmap? = null
    var princessWalkBack: AnimatedBitmap? = null
    var princessWalkRight: AnimatedBitmap? = null
    var princessWalkLeft: AnimatedBitmap? = null
    var princessDead: AnimatedBitmap? = null
    private var princessSprites: Bitmap? = null
    private var princess: SpriteSheet? = null

    var princessPotionStopFront: Bitmap? = null
    var princessPotionStopBack: Bitmap? = null
    var princessPotionStopRight: Bitmap? = null
    var princessPotionStopLeft: Bitmap? = null
    var princessPotionWalkFront: AnimatedBitmap? = null
    var princessPotionWalkBack: AnimatedBitmap? = null
    var princessPotionWalkRight: AnimatedBitmap? = null
    var princessPotionWalkLeft: AnimatedBitmap? = null
    private var princessPotionSprites: Bitmap? = null
    private var princessPotion: SpriteSheet? = null


    var enemy1Front: AnimatedBitmap? = null
    var enemy1Back: AnimatedBitmap? = null
    var enemy1Right: AnimatedBitmap? = null
    var enemy1Left: AnimatedBitmap? = null
    private var enemy1Sprites: Bitmap? = null
    private var enemy1: SpriteSheet? = null

    var enemy2Front: AnimatedBitmap? = null
    var enemy2Back: AnimatedBitmap? = null
    var enemy2Right: AnimatedBitmap? = null
    var enemy2Left: AnimatedBitmap? = null
    private var enemy2Sprites: Bitmap? = null
    private var enemy2: SpriteSheet? = null

    var enemy3Front: AnimatedBitmap? = null
    var enemy3Back: AnimatedBitmap? = null
    var enemy3Right: AnimatedBitmap? = null
    var enemy3Left: AnimatedBitmap? = null
    private var enemy3Sprites: Bitmap? = null
    private var enemy3: SpriteSheet? = null

    var enemy4Front: AnimatedBitmap? = null
    var enemy4Back: AnimatedBitmap? = null
    var enemy4Right: AnimatedBitmap? = null
    var enemy4Left: AnimatedBitmap? = null
    private var enemy4Sprites: Bitmap? = null
    private var enemy4: SpriteSheet? = null

    var potion: Bitmap? = null

    var verticalWall: Bitmap? = null
    var horizontalWall: Bitmap? = null
    var verticalHorizontalWall: Bitmap? = null
    var verticalLeftWall: Bitmap? = null
    var horizontalDownWall: Bitmap? = null
    var verticalRightWall: Bitmap? = null
    var horizontalUpWall: Bitmap? = null
    var upRightWall: Bitmap? = null
    var upLeftWall: Bitmap? = null
    var downLeftWall: Bitmap? = null
    var downRightWall: Bitmap? = null
    var endLeftWall: Bitmap? = null
    var endUpWall: Bitmap? = null
    var endRightWall: Bitmap? = null
    var endDownWall: Bitmap? = null

    private var walls : SpriteSheet? = null
    private var wallSprites : Bitmap? = null


    fun createAssets(context: Context, scale: Int) {
        val resources = context.resources
        wallSprites?.recycle()
        wallSprites = BitmapFactory.decodeResource(resources, R.drawable.walls_xpacman)
        walls = SpriteSheet(wallSprites, SPRITE_WALL_SIDE, SPRITE_WALL_SIDE).apply {
            verticalWall?.recycle()
            verticalWall = getScaledSprite(0, VERTICAL_WALL_INDEX, scale, scale)
            horizontalWall?.recycle()
            horizontalWall = getScaledSprite(0, HORIZONTAL_WALL_INDEX, scale, scale)
            verticalHorizontalWall?.recycle()
            verticalHorizontalWall = getScaledSprite(0, VERTICAL_HORIZONTAL_WALL_INDEX, scale, scale)
            verticalLeftWall?.recycle()
            verticalLeftWall = getScaledSprite(0, VERTICAL_LEFT_WALL_INDEX, scale, scale)
            horizontalDownWall?.recycle()
            horizontalDownWall = getScaledSprite(0, HORIZONTAL_DOWN_WALL_INDEX, scale, scale)
            verticalRightWall?.recycle()
            verticalRightWall = getScaledSprite(0, VERTICAL_RIGHT_WALL_INDEX, scale, scale)
            horizontalUpWall?.recycle()
            horizontalUpWall = getScaledSprite(0, HORIZONTAL_UP_WALL_INDEX, scale, scale)
            upRightWall?.recycle()
            upRightWall = getScaledSprite(0, UP_RIGHT_WALL_INDEX, scale, scale)
            upLeftWall?.recycle()
            upLeftWall = getScaledSprite(0, UP_LEFT_WALL_INDEX, scale, scale)
            downLeftWall?.recycle()
            downLeftWall = getScaledSprite(0, DOWN_LEFT_WALL_INDEX, scale, scale)
            downRightWall?.recycle()
            downRightWall = getScaledSprite(0, DOWN_RIGHT_WALL_INDEX, scale, scale)
            endLeftWall?.recycle()
            endLeftWall = getScaledSprite(0, END_LEFT_WALL_INDEX, scale, scale)
            endUpWall?.recycle()
            endUpWall = getScaledSprite(0, END_UP_WALL_INDEX, scale, scale)
            endRightWall?.recycle()
            endRightWall = getScaledSprite(0, END_RIGHT_WALL_INDEX, scale, scale)
            endDownWall?.recycle()
            endDownWall = getScaledSprite(0, END_DOWN_WALL_INDEX, scale, scale)
        }

        princessSprites?.recycle()
        princessSprites = BitmapFactory.decodeResource(resources, R.drawable.princess)
        princess = SpriteSheet(princessSprites, CHARACTERS_SIDE, CHARACTERS_SIDE).apply {
            princessStopFront?.recycle()
            princessStopFront = getScaledSprite(FRONT_INDEX, 0, scale, scale)
            princessStopBack?.recycle()
            princessStopBack = getScaledSprite(BACK_INDEX, 0, scale, scale)
            princessStopRight?.recycle()
            princessStopRight = getScaledSprite(RIGHT_INDEX, 0, scale, scale)
            princessStopLeft?.recycle()
            princessStopLeft = getScaledSprite(LEFT_INDEX, 0, scale, scale)

        }

        princessWalkFront?.recycle()
        princessWalkFront = createAnimation(princess!!, FRONT_INDEX, WALK_FRAMES, scale)
        princessWalkBack?.recycle()
        princessWalkBack = createAnimation(princess!!, BACK_INDEX, WALK_FRAMES, scale)
        princessWalkRight?.recycle()
        princessWalkRight = createAnimation(princess!!, RIGHT_INDEX, WALK_FRAMES, scale)
        princessWalkLeft?.recycle()
        princessWalkLeft = createAnimation(princess!!, LEFT_INDEX, WALK_FRAMES, scale)
        princessDead?.recycle()
        princessDead = createAnimation(princess!!, DEAD_INDEX, DEAD_FRAMES, scale)


        princessPotionSprites?.recycle()
        princessPotionSprites = BitmapFactory.decodeResource(resources, R.drawable.princess_potion)
        princessPotion = SpriteSheet(princessPotionSprites, CHARACTERS_SIDE, CHARACTERS_SIDE).apply {
            princessPotionStopFront?.recycle()
            princessPotionStopFront = getScaledSprite(FRONT_INDEX, 0, scale, scale)
            princessPotionStopBack?.recycle()
            princessPotionStopBack = getScaledSprite(BACK_INDEX, 0, scale, scale)
            princessPotionStopRight?.recycle()
            princessPotionStopRight = getScaledSprite(RIGHT_INDEX, 0, scale, scale)
            princessPotionStopLeft?.recycle()
            princessPotionStopLeft = getScaledSprite(LEFT_INDEX, 0, scale, scale)

        }

        princessPotionWalkFront?.recycle()
        princessPotionWalkFront = createAnimation(princessPotion!!, FRONT_INDEX, WALK_FRAMES, scale)
        princessPotionWalkBack?.recycle()
        princessPotionWalkBack = createAnimation(princessPotion!!, BACK_INDEX, WALK_FRAMES, scale)
        princessPotionWalkRight?.recycle()
        princessPotionWalkRight = createAnimation(princessPotion!!, RIGHT_INDEX, WALK_FRAMES, scale)
        princessPotionWalkLeft?.recycle()
        princessPotionWalkLeft = createAnimation(princessPotion!!, LEFT_INDEX, WALK_FRAMES, scale)


        enemy1Sprites?.recycle()
        enemy1Sprites = BitmapFactory.decodeResource(resources, R.drawable.brown_skeleton)
        enemy1 = SpriteSheet(enemy1Sprites, CHARACTERS_SIDE, CHARACTERS_SIDE)

        enemy1Front?.recycle()
        enemy1Front = createAnimation(enemy1!!, FRONT_INDEX, WALK_FRAMES, scale)
        enemy1Back?.recycle()
        enemy1Back = createAnimation(enemy1!!, BACK_INDEX, WALK_FRAMES, scale)
        enemy1Right?.recycle()
        enemy1Right = createAnimation(enemy1!!, RIGHT_INDEX, WALK_FRAMES, scale)
        enemy1Left?.recycle()
        enemy1Left = createAnimation(enemy1!!, LEFT_INDEX, WALK_FRAMES, scale)

        enemy2Sprites?.recycle()
        enemy2Sprites = BitmapFactory.decodeResource(resources, R.drawable.blue_skeleton)
        enemy2 = SpriteSheet(enemy2Sprites, CHARACTERS_SIDE, CHARACTERS_SIDE)

        enemy2Front?.recycle()
        enemy2Front = createAnimation(enemy2!!, FRONT_INDEX, WALK_FRAMES, scale)
        enemy2Back?.recycle()
        enemy2Back = createAnimation(enemy2!!, BACK_INDEX, WALK_FRAMES, scale)
        enemy2Right?.recycle()
        enemy2Right = createAnimation(enemy2!!, RIGHT_INDEX, WALK_FRAMES, scale)
        enemy2Left?.recycle()
        enemy2Left = createAnimation(enemy2!!, LEFT_INDEX, WALK_FRAMES, scale)

        enemy3Sprites?.recycle()
        enemy3Sprites = BitmapFactory.decodeResource(resources, R.drawable.red_skeleton)
        enemy3 = SpriteSheet(enemy3Sprites, CHARACTERS_SIDE, CHARACTERS_SIDE)

        enemy3Front?.recycle()
        enemy3Front = createAnimation(enemy3!!, FRONT_INDEX, WALK_FRAMES, scale)
        enemy3Back?.recycle()
        enemy3Back = createAnimation(enemy3!!, BACK_INDEX, WALK_FRAMES, scale)
        enemy3Right?.recycle()
        enemy3Right = createAnimation(enemy3!!, RIGHT_INDEX, WALK_FRAMES, scale)
        enemy3Left?.recycle()
        enemy3Left = createAnimation(enemy3!!, LEFT_INDEX, WALK_FRAMES, scale)

        enemy4Sprites?.recycle()
        enemy4Sprites = BitmapFactory.decodeResource(resources, R.drawable.monk_skeleton)
        enemy4 = SpriteSheet(enemy4Sprites, CHARACTERS_SIDE, CHARACTERS_SIDE)

        enemy4Front?.recycle()
        enemy4Front = createAnimation(enemy4!!, FRONT_INDEX, WALK_FRAMES, scale)
        enemy4Back?.recycle()
        enemy4Back = createAnimation(enemy4!!, BACK_INDEX, WALK_FRAMES, scale)
        enemy4Right?.recycle()
        enemy4Right = createAnimation(enemy4!!, RIGHT_INDEX, WALK_FRAMES, scale)
        enemy4Left?.recycle()
        enemy4Left = createAnimation(enemy4!!, LEFT_INDEX, WALK_FRAMES, scale)

        potion?.recycle()
        potion = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.potion), scale, scale, true)

    }

    private fun createAnimation(spriteSheet: SpriteSheet, index: Int, frames: Int, scale: Int): AnimatedBitmap {
        val sprites = spriteSheet.getScaledRow(index, frames, scale, scale)
        return AnimatedBitmap(frames/2f, *sprites)
    }
}