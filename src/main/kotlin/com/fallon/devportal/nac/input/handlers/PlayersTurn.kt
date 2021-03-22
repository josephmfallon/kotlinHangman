package com.fallon.devportal.nac.input.handlers

import com.fallon.devportal.nac.NoughtsAndCrosses
import com.fallon.devportal.nac.NoughtsAndCrosses.state
import com.fallon.devportal.nac.State
import com.fallon.devportal.nac.grid.Grid
import com.fallon.devportal.nac.input.InputHandler
import com.fallon.devportal.nac.input.InputResult

class PlayersTurn(private val grid: Grid) : InputHandler {

    override fun shouldHandle(): Boolean {
        return NoughtsAndCrosses.state == State.GameRound
    }

    override fun getQuestion(): String {
        return "Please enter tile coordinate"
    }

    override fun handleInput(string: String): InputResult {
        val array = string.toCharArray()

        val x = array.first().toString().toIntOrNull()
        val y = array.last().toString().toIntOrNull()

        if (x != null && y != null && grid.setIfEmpty(x, y, NoughtsAndCrosses.selection)) {
            val winner = grid.getWinner()
            if(winner != null) {
                state = if (winner == NoughtsAndCrosses.selection) State.Win else State.Lose
            }
            return InputResult.ContinueToNextHandler
        } else {
            System.err.println("Invalid tile $string")
            return InputResult.ReturnToLoop1
        }
    }
}