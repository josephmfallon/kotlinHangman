package com.aevi.devportal

object Main {
    /*
        Naughts and crosses

        ~Grid~
        ~XOChar selection~
        ~player always takes first turn~
        ~player input~
            ~coordinate for players turn~
            ~reset~
        ~Setting tile~
            if tile set
                cant set
            else
                set
         Computer choice
            random
        Winning state
            horizontal
            vertical
            diagonal
        Draw state
     */

    var state: State = State.CharacterSelection
    lateinit var selection: XOChar
    val grid = Grid()

    fun reset() {
        state = State.GameRound
        grid.reset()
        grid.display()
        println("Grid reset")
        println("Please enter tile coordinate")
    }


    fun playerReset(line: String): Boolean {
        if (state != State.CharacterSelection) {
            if (line.equals("reset", true)) {
                reset()
                return true
            }
        }
        return false
    }

    fun characterSelection(line: String): Boolean {
        if (state == State.CharacterSelection) {
            val character = line.toCharArray().first()
            if (character == XOChar.O.character || character == XOChar.X.character) {
                println("You have chosen $character")
                selection = XOChar.find(character)
                state = State.GameRound
                grid.display()
                println("Please enter tile coordinate")
            } else {
                System.err.println("Not a valid character.")
                println("Please choose a character 'X' or 'O'")
            }
            return true
        } else {
            return false
        }
    }

    fun getWinner(): XOChar? {
        if(grid.getWinner(XOChar.X)) {
            return XOChar.X
        }
        if(grid.getWinner(XOChar.O)) {
            return XOChar.O
        }
        return null
    }

    fun gameOver(line: String) : Boolean {
        if(state == State.GameOver) {
            if(line.isNotEmpty()) {
                reset()
                return true
            }
        }
        return false
    }

    fun playerTurn(line: String): Boolean {
        if (state == State.GameRound) {
            val array = line.toCharArray()

            val x = array.first().toString().toIntOrNull()
            val y = array.last().toString().toIntOrNull()

            if (x != null && y != null && grid.setIfEmpty(x, y, selection)) {
                var winner = getWinner()
                if(winner != null) {
                    //Player turn check
                    state = State.GameOver
                    println(if(winner == selection) "Congratulations! You've won!" else "Game Over, you lost!")
                    println("Enter anything to replay.")
                } else {
                    computersTurn()
                    winner = getWinner()
                    if(winner != null) {
                        //Computer turn check
                        state = State.GameOver
                        println(if(winner == selection) "Congratulations! You've won!" else "Game Over, you lost!")
                        println("Enter anything to replay.")
                    }
                }
            } else {
                System.err.println("Invalid tile $line")
                println("Please enter tile coordinate")
            }
            return true
        }
        return false
    }


    fun computersTurn() {
        val freeTiles = grid.getFreeTiles()
        if(freeTiles.isEmpty()) {
            //draw
            return
        } else {
            val (randomX, randomY) = freeTiles.random()
            grid.set(randomX, randomY, selection.opposite())
            grid.display()
            println("Computer turn complete, please enter a tile coordinate")
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {


//        grid.set(0, 1, XOChar.X)

        var isRunning = true

        println("Please choose a character 'X' or 'O'")

        while (isRunning) {
            val line = readLine()!!

            if (gameOver(line)) {
                continue
            }

            if (playerReset(line)) {
                continue
            }

            if (characterSelection(line)) {
                continue
            }

            if (playerTurn(line)) {
                continue
            }
        }

    }


}