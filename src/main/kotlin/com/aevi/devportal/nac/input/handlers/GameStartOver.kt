package com.aevi.devportal.nac.input.handlers

import com.aevi.devportal.nac.grid.Grid
import com.aevi.devportal.nac.input.InputHandler
import com.aevi.devportal.nac.input.InputResult
import com.aevi.devportal.nac.NoughtsAndCrosses.state
import com.aevi.devportal.nac.State

class GameStartOver(private val grid: Grid) : InputHandler {
    override fun shouldHandle(): Boolean {
        return state == State.GameOver
    }

    override fun getQuestion(): String? {
        return "Enter anything to replay."
    }

    override fun handleInput(string: String): InputResult {
        if(string.isNotEmpty()) {
            state = State.GameRound
            grid.reset()
            grid.display()
            println("New game started")
        }
        return InputResult.ReturnToLoop1
    }
}