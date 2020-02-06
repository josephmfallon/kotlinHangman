package com.aevi.devportal.handlers

import com.aevi.devportal.InputHandler
import com.aevi.devportal.InputResult
import com.aevi.devportal.Main.grid
import com.aevi.devportal.Main.state
import com.aevi.devportal.State

class GameStartOver : InputHandler {
    override fun shouldHandle(): Boolean {
        return state == State.GameOver
    }

    override fun getQuestion(): String? {
        return null
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