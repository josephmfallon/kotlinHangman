package com.aevi.devportal.handlers

import com.aevi.devportal.*
import com.aevi.devportal.Main.state

class PlayersTurn(private val grid: Grid) : InputHandler {

    override fun shouldHandle(): Boolean {
        return Main.state == State.GameRound
    }

    override fun getQuestion(): String {
        return "Please enter tile coordinate"
    }

    override fun handleInput(string: String): InputResult {
        val array = string.toCharArray()

        val x = array.first().toString().toIntOrNull()
        val y = array.last().toString().toIntOrNull()

        if (x != null && y != null && grid.setIfEmpty(x, y, Main.selection)) {
            val winner = grid.getWinner()
            if(winner != null) {
                state = if (winner == Main.selection) State.Win else State.Lose
            }
            return InputResult.ContinueToNextHandler
        } else {
            System.err.println("Invalid tile $string")
            return InputResult.ReturnToLoop1
        }
    }
}