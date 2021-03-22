package com.fallon.devportal.nac.input.handlers

import com.fallon.devportal.nac.grid.Grid
import com.fallon.devportal.nac.input.InputHandler
import com.fallon.devportal.nac.input.InputResult
import com.fallon.devportal.nac.NoughtsAndCrosses.state
import com.fallon.devportal.nac.State

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