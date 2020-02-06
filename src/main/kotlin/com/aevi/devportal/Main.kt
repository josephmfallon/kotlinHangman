package com.aevi.devportal

import com.aevi.devportal.handlers.*

object Main {

    var state: State = State.CharacterSelection
    lateinit var selection: XOChar
    val grid = TileGrid()

    @JvmStatic
    fun main(args: Array<String>) {


        var isRunning = true

        val arrayOfInputHandlers = arrayOf(
            CharacterSelection(grid),
            Exit(),
            GameStartOver(grid),
            GameReset(grid),
            PlayersTurn(grid),
            ComputersTurn(grid),
            Outcome(grid)
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
                    if(whichResult == InputResult.StopRunning) {
                        isRunning = false
                        break
                    }
                }
            }
        }

    }


}