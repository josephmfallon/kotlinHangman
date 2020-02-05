package com.aevi.devportal.handlers

import com.aevi.devportal.*

class CharacterSelection : InputHandler {

    override fun shouldHandle(): Boolean {
        return Main.state == State.CharacterSelection
    }

    override fun getQuestion(): String? {
        return "Please choose a character 'X' or 'O'"
    }

    override fun handleInput(string: String): InputResult {
        val character = string.toCharArray().first()
        if (character == XOChar.O.character || character == XOChar.X.character) {
            println("You have chosen $character")
            Main.selection = XOChar.find(character)
            Main.state = State.GameRound
            Main.grid.display()
            return InputResult.ReturnToLoop1
        } else {
            System.err.println("Not a valid character.")
            return InputResult.InvalidInput
        }
    }
}