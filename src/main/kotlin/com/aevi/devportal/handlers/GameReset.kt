package com.aevi.devportal.handlers

import com.aevi.devportal.InputHandler
import com.aevi.devportal.InputResult
import com.aevi.devportal.Main.grid
import com.aevi.devportal.Main.state
import com.aevi.devportal.State

class GameReset : InputHandler {
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