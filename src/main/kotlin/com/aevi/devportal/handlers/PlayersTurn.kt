package com.aevi.devportal.handlers

import com.aevi.devportal.InputHandler
import com.aevi.devportal.InputResult
import com.aevi.devportal.Main
import com.aevi.devportal.Main.won
import com.aevi.devportal.State

class PlayersTurn : InputHandler {

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

        if (x != null && y != null && Main.grid.setIfEmpty(x, y, Main.selection)) {
            val winner = Main.getWinner()
            if(won(winner)) {
                return InputResult.ReturnToLoop1
            } else {
                return InputResult.ContinueToNextHandler
            }
        } else {
            System.err.println("Invalid tile $string")
            return InputResult.ReturnToLoop1
        }
    }
}