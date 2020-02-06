package com.aevi.devportal

import com.aevi.devportal.handlers.*

object Main {

    var state: State = State.CharacterSelection
    lateinit var selection: XOChar
    val grid = Grid()

    fun getWinner(): XOChar? {
        if(grid.getWinner(XOChar.X)) {
            return XOChar.X
        }
        if(grid.getWinner(XOChar.O)) {
            return XOChar.O
        }
        return null
    }

    fun won(winner: XOChar?): Boolean {
        if(winner != null) {
            Main.state = State.GameOver
            println(if(winner == Main.selection) "Congratulations! You've won!" else "Game Over, you lost!")
            println("Enter anything to replay.")
            return true
        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {


        var isRunning = true

        val arrayOfInputHandlers = arrayOf(
            CharacterSelection(),
            GameStartOver(),
            GameReset(),
            PlayersTurn(),
            ComputersTurn()
        )

        while (isRunning) {//Loop 1
            //question
            //terminal print logic
            for(handler in arrayOfInputHandlers) {
                if(handler.shouldHandle()) {
                    val question = handler.getQuestion()
                    if (question != null) {
                        println(question)
                        break
                    }
                }
            }

            val line = readLine()!!
            //Run logic
            for(handler in arrayOfInputHandlers) {
                if(handler.shouldHandle()) {
                    val whichResult = handler.handleInput(line)

                    if(whichResult == InputResult.ReturnToLoop1) {
                        break
                    }
                }
            }
        }

    }


}