package com.example.barbariangold.model

import android.os.CountDownTimer
import com.example.barbariangold.Assets
import com.example.barbariangold.Enemy
import es.uji.jvilar.barbariangold.model.CellType
import es.uji.jvilar.barbariangold.model.Direction
import es.uji.jvilar.barbariangold.model.Maze
import es.uji.jvilar.barbariangold.model.Position
import es.uji.vj1229.framework.AnimatedBitmap
import kotlin.math.roundToInt

object Levels {
    val all = arrayOf (
        Maze(arrayOf(
            "#############################",    //LEVEL 1
            "#...........................#",
            "#.##.#.###############.#.##.#",
            "#.##P#.####### #######.#P##.#",
            "#....#.......# #.......#.##.#",
            "####.#######.###.#######....#",
            "#  #.#.................#.####",
            "####.#.###.###D###.###.#.####",
            "#......# #.#HH HH#.# #......#",
            "#.#.##.###.#######.###.##.#.#",
            "#.#.##.................##.#.#",
            "#.#.##.#######.#######.##.#.#",
            "#.#........#.....#..........#",
            "#P########.#.###.#.########P#",
            "#.########.#.###.#.########.#",
            "#.............O.............#",
            "#############################",
        )),
        Maze(arrayOf(
            "#############################",    //LEVEL 2
            "#.............#..........P..#",
            "#.####.######.#.######.####.#",
            "#.####.######.#.######.####.#",
            "#.P.........................#",
            "####.###.###.###.#####.######",
            "####.###...............######",
            "#....###.#.###D###.###......#",
            "#.##.....#.#HH HH#.# #.##.#.#",
            "#.##.#.###.#######.###.##.#.#",
            "#.##.#.................##.#.#",
            "#.##.#.#######.#######.##.#.#",
            "#.........##.....##.........#",
            "#P###.###..#.###.##.###.###P#",
            "#.###.####.#.###.##.###.###.#",
            "#.............O.............#",
            "#############################",
        )),
        Maze(arrayOf(
            "#############################",    //LEVEL 3
            "#....#....#...#...#...#....P#",
            "#P##...##...#...#...#.#.###.#",
            "#.##.####.#########.#.#.# #.#",
            "#.............#.....#.#.###.#",
            "#.##.##.##.##.#.##.##.#.....#",
            "#.......##.........#..#..##.#",
            "####.##.##.###D###.#.###.##.#",
            "####.##.##.#HH HH#.#.....##.#",
            "#....##.##.#######.#.###....#",
            "#.##.....................####",
            "#.#########.#####.##.###....#",
            "#......#......O....#.# #.##P#",
            "#.####.#.#.#.##.##.#.# #.##.#",
            "#P####.#.#.#.##.##.#.###.##.#",
            "#......#...#....##..........#",
            "#############################",
        )),
        Maze(arrayOf(
            "#############################",    //LEVEL 4
            "#P......#...#.....#........P#",
            "#.#####.#.#.#.###.#.#######.#",
            "#.#.....#.#.#...#.#.......#.#",
            "#.#.##.##.#...#.#.#.#####.#.#",
            "#...#.....#.###.#.#.#.....#.#",
            "#.#...#.#.............###.#.#",
            "#.#####.##.###D###.##.# #...#",
            "#........#.#HH HH#.##.###.###",
            "#.###.##.#.#######..........#",
            "#.# #.##.#.........##.###.#.#",
            "#.###.##.##.##.###.#......#.#",
            "#P...................#.####.#",
            "#.#.####.#.###O#.#.###......#",
            "#.#.####.#.###.#.#.....####.#",
            "#........#.......#####.....P#",
            "#############################",
        )),
        Maze(arrayOf(
            "#############################",    //LEVEL 5
            "#P............#........#...P#",
            "#.#.######.##.#.####.#.#.##.#",
            "#.#.#    #.##.#.####.#.#....#",
            "#.#.######.........#.#.#.##.#",
            "#.#........#######.#.#...##.#",
            "#.#.##.###.........#.###.##.#",
            "#.#.##.# #.###D###.#...#.##.#",
            "#.#.##.###.#HH HH#.###.#....#",
            "#.#........#######.....#.####",
            "#....#.###.........###.#...P#",
            "#.##.#.#...##.#.##...#.#.##.#",
            "#.##.#.#.#.##.#.##.#.#......#",
            "#..P.#.#.#..#.#.#..#.#.#.##.#",
            "#.####.#.##.#.#.#.##.#.#.##.#",
            "#......#......O......#......#",
            "#############################",
        )),
        Maze(arrayOf(
            "#############################",    //LEVEL 6
            "#..........................P#",
            "#.###.#.##.##.#.#.##.#.####.#",
            "#.#...#.##.##.#.#.##.#....#.#",
            "#.#.#.#.##...P#.#....#.##.#.#",
            "#.#.#.#....####.####.#.##.#.#",
            "#..P..####...........#.##.#.#",
            "#.###......###D###.#.#....#.#",
            "#.#...####.#HH HH#.#.#.##...#",
            "#.#.#.#....#######.#.#....#.#",
            "#...#.#.##.........#.#.####.#",
            "#.#.#.#.##.#########.#......#",
            "#.#.#.#.##....O......#.##.#.#",
            "#.#...#.##.##.#.####.#....#.#",
            "#.###.#.##.##.#.####.#.####.#",
            "#.............#P............#",
            "#############################",
        )))
}


class BarbarianGoldModel {

    var maze : Maze
        private set

    private var level : Int = 0
    var numCols : Int = 0
    var numRows : Int = 0
    var score : Int = 0
    private var numGolds : Int = 0
    var gameover : Boolean = false
    var dead : Boolean = false

    var princessX : Float = 0f
    var princessY : Float = 0f
    private val princesSpeed : Int = 3
    private var princessPosition = Position(0,0)
    var princessDirection: Direction = Direction.DOWN

    var isMoving : Boolean = false
    var takesPotion : Boolean = false
    var lives: Int = 3
    var princessSprite : AnimatedBitmap? = null

    var enemies = ArrayList<Enemy>()

    private var potionTimer : CountDownTimer? = null
    private var deadTimer : CountDownTimer? = null

    init {

        maze = Levels.all[level]
        numCols = maze.nCols
        numRows = maze.nRows
        numGolds = maze.gold

        princessPosition.set(maze.origin.row, maze.origin.col)
        toCenterPrincess()

        for(e in 0..3){
            val enemy = Enemy(0f, 0f, Position(0,0), Position(0,0),3, Direction.UP, Assets.enemy2Front)
            enemy.position.set(maze.enemyOrigins[e].row,maze.enemyOrigins[e].col)
            toCenterEnemy(enemy)
            enemies.add(enemy)
        }

        potionTimer = object : CountDownTimer(8000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() { takesPotion = false }
        }

        deadTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                princessPosition.set(maze.origin.row, maze.origin.col)
                toCenterPrincess()
                princessDirection = Direction.DOWN

                isMoving = false
                takesPotion = false

                lives--
                if (lives <= 0){
                    gameover = true
                }
                dead = false
            }
        }

    }


    fun updatePrincessDirection(nextPrincessDirection : Direction?){
        if(nextPrincessDirection != null){
            if (isMoving){
                if ((princessDirection  != nextPrincessDirection) && !maze[princessPosition].hasWall(nextPrincessDirection) && maze[princessPosition.translate(nextPrincessDirection)].type != CellType.DOOR) {
                    toCenterPrincess()
                    princessDirection = nextPrincessDirection
                }
            }
            else{
                if (!maze[princessPosition].hasWall(nextPrincessDirection) && maze[princessPosition.translate(nextPrincessDirection)].type != CellType.DOOR) {
                    toCenterPrincess()
                    princessDirection = nextPrincessDirection
                    isMoving = true
                }
            }
        }
    }


    fun update(deltaTime: Float){
        if (gameover || dead){
            return
        }
        else{
            movePrincess(deltaTime)
            for(e in 0 until enemies.size){
                moveEnemies(deltaTime, enemies[e])
                checkColision(enemies[e])
            }
        }
    }

    private fun movePrincess(deltaTime: Float){

        if(isMoving){

            if (!maze[princessPosition].hasWall(princessDirection) && maze[princessPosition.translate(princessDirection)].type != CellType.DOOR) {
                princessX += princesSpeed * deltaTime * princessDirection.col
                princessY += princesSpeed * deltaTime * princessDirection.row
                princessPosition.set((princessY - 0.5f).roundToInt(),(princessX - 0.5f).roundToInt())

                if(!maze[princessPosition].used){
                    maze[princessPosition].used = true

                    if (maze[princessPosition].type == CellType.GOLD){
                        score += 5
                        numGolds --
                        if (numGolds == 0){
                            changeLevel()
                        }
                    }

                    if (maze[princessPosition].type == CellType.POTION){
                        takesPotion = true
                        potionTimer?.start()
                    }
                }

            }else{
                toCenterPrincess()
                isMoving = false
            }
        }

    }


    private fun moveEnemies(deltaTime: Float, enemy: Enemy){
        enemy.X += enemy.speed * deltaTime * enemy.direction.col
        enemy.Y += enemy.speed * deltaTime * enemy.direction.row

        if (!maze[enemy.position].hasWall(enemy.direction)){
            enemy.position.set((enemy.Y - 0.5f).roundToInt(),(enemy.X - 0.5f).roundToInt())
        }

        if(enemy.position != enemy.lastPosition){
            updateEnemyDirection(enemy)
            enemy.lastPosition.set((enemy.Y - 0.5f).roundToInt(),(enemy.X - 0.5f).roundToInt())
        }
    }


    private fun updateEnemyDirection(enemy: Enemy){
        if (!maze[enemy.position].hasWall(enemy.direction.turnRight()) || !maze[enemy.position].hasWall(enemy.direction.turnLeft())) {
            val newDirection = fixDirection(enemy)
            if (enemy.direction != newDirection) {
                toCenterEnemy(enemy)
                enemy.direction = newDirection
            }
        }

        else if (maze[enemy.position].hasWall(enemy.direction.turnRight()) && maze[enemy.position].hasWall(enemy.direction.turnLeft()) && maze[enemy.position].hasWall(enemy.direction)){
            enemy.direction = enemy.direction.opposite()
        }
    }


    private fun fixDirection(enemy: Enemy) : Direction{
        var dir = enemy.direction
        if (maze[enemy.position].hasWall(enemy.direction.turnRight()) && !maze[enemy.position].hasWall(enemy.direction.turnLeft()) && !maze[enemy.position].hasWall(enemy.direction)){
            val directions = listOf(enemy.direction.turnLeft(), enemy.direction)
            dir = directions.random()
        }
        else if (!maze[enemy.position].hasWall(enemy.direction.turnRight()) && maze[enemy.position].hasWall(enemy.direction.turnLeft()) && !maze[enemy.position].hasWall(enemy.direction)){
            val directions = listOf(enemy.direction.turnRight(), enemy.direction)
            dir = directions.random()
        }
        else if (!maze[enemy.position].hasWall(enemy.direction.turnRight()) && !maze[enemy.position].hasWall(enemy.direction.turnLeft()) && !maze[enemy.position].hasWall(enemy.direction)){
            val directions = listOf(enemy.direction.turnRight(), enemy.direction.turnLeft(), enemy.direction)
            dir = directions.random()
        }
        else if (!maze[enemy.position].hasWall(enemy.direction.turnRight()) && !maze[enemy.position].hasWall(enemy.direction.turnLeft()) && maze[enemy.position].hasWall(enemy.direction)){
            val directions = listOf(enemy.direction.turnRight(), enemy.direction.turnLeft())
            dir = directions.random()
        }
        else if (!maze[enemy.position].hasWall(enemy.direction.turnRight()) && maze[enemy.position].hasWall(enemy.direction.turnLeft()) && maze[enemy.position].hasWall(enemy.direction)){
            dir = enemy.direction.turnRight()
        }
        else if (maze[enemy.position].hasWall(enemy.direction.turnRight()) && !maze[enemy.position].hasWall(enemy.direction.turnLeft()) && maze[enemy.position].hasWall(enemy.direction)){
            dir = enemy.direction.turnLeft()
        }

        return dir
    }


    private fun checkColision(enemy: Enemy){
        if (kotlin.math.abs(princessPosition.col - enemy.position.col) <= 0.4f && kotlin.math.abs(princessPosition.row - enemy.position.row) <= 0.4f){

            if(takesPotion){
                enemy.position.set(maze.enemyOrigins[0].row,maze.enemyOrigins[0].col )
                toCenterEnemy(enemy)
                score += 50

            }else{
                if(!dead){
                    for(e in 0 until enemies.size){
                        enemies[e].position.set(maze.enemyOrigins[e].row,maze.enemyOrigins[e].col )
                        toCenterEnemy(enemies[e])
                    }
                    dead = true
                    deadTimer?.start()
                }
            }
        }
    }


    private fun changeLevel(){
        if(level < Levels.all.size - 1){
            level++
            maze = Levels.all[level]
        }

        restart()
    }


    fun gameOver(){
        score = 0
        level = 0
        maze = Levels.all[level]
        restart()
    }


    private fun restart(){
        for(e in 0 until enemies.size){
            enemies[e].position.set(maze.enemyOrigins[e].row,maze.enemyOrigins[e].col )
            toCenterEnemy(enemies[e])
        }

        princessPosition.set(maze.origin.row, maze.origin.col)
        toCenterPrincess()
        princessDirection = Direction.DOWN

        lives = 3
        isMoving = false
        takesPotion = false

        numGolds = maze.gold
        gameover = false
        dead = false
        maze.reset()
    }


    private fun toCenterPrincess() {
        princessX = princessPosition.col + 0.5f
        princessY = princessPosition.row + 0.5f
    }

    private fun toCenterEnemy(enemy: Enemy) {
        enemy.X = enemy.position.col + 0.5f
        enemy.Y = enemy.position.row + 0.5f
    }

}