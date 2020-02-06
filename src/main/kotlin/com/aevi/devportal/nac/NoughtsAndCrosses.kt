package com.aevi.devportal.nac

import com.aevi.devportal.nac.grid.TileGrid
import com.aevi.devportal.nac.input.InputResult
import com.aevi.devportal.nac.input.handlers.*

object NoughtsAndCrosses {

    var state: State =
        State.CharacterSelection
    lateinit var selection: XOChar

    @JvmStatic
    fun main(args: Array<String>) {
        var isRunning = true

        val grid = TileGrid()
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