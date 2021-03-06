package com.fallon.devportal.nac.input.handlers

import com.fallon.devportal.nac.grid.Grid
import com.fallon.devportal.nac.input.InputHandler
import com.fallon.devportal.nac.input.InputResult
import com.fallon.devportal.nac.NoughtsAndCrosses.state
import com.fallon.devportal.nac.State

class GameReset(private val grid: Grid) : InputHandler {

    override fun shouldHandle(): Boolean {
        return state == State.GameRound
    }

    override fun getQuestion(): String? {
        return null//"Enter reset if you are sure?"
    }

    override fun handleInput(string: String): InputResult {
        if (string.equals("reset", true)) {
            grid.reset()
            grid.display()
            println("Grid reset")
            return InputResult.ReturnToLoop1
        }
        return InputResult.ContinueToNextHandler
    }
}