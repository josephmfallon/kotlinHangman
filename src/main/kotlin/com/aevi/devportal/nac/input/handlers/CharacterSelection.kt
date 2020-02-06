package com.aevi.devportal.nac.input.handlers

import com.aevi.devportal.nac.NoughtsAndCrosses.selection
import com.aevi.devportal.nac.NoughtsAndCrosses.state
import com.aevi.devportal.nac.State
import com.aevi.devportal.nac.XOChar
import com.aevi.devportal.nac.grid.Grid
import com.aevi.devportal.nac.input.InputHandler
import com.aevi.devportal.nac.input.InputResult

class CharacterSelection(private val grid: Grid) : InputHandler {

    override fun shouldHandle(): Boolean {
        return state == State.CharacterSelection
    }

    override fun getQuestion(): String? {
        return "Please choose a character 'X' or 'O'"
    }

    override fun handleInput(string: String): InputResult {
        val character = string.toCharArray().first()
        if (character == XOChar.O.character || character == XOChar.X.character) {
            println("You have chosen $character")
            selection = XOChar.find(character)
            state = State.GameRound
            grid.display()
            return InputResult.ReturnToLoop1
        } else {
            System.err.println("Not a valid character.")
            return InputResult.InvalidInput
        }
    }
}