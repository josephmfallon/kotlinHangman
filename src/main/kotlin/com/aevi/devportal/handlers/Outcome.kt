package com.aevi.devportal.handlers

import com.aevi.devportal.Grid
import com.aevi.devportal.InputHandler
import com.aevi.devportal.InputResult
import com.aevi.devportal.Main.state
import com.aevi.devportal.State

class Outcome(private val grid: Grid) : InputHandler {

    override fun shouldHandle(): Boolean {
        return state == State.Win || state == State.Lose
    }

    override fun getQuestion(): String? {
        return null
    }

    override fun handleInput(string: String): InputResult {
        grid.display()
        println(if(state == State.Win) "Congratulations! You've won!" else "Game over, you've lost!")
        state = State.GameOver
        return InputResult.ReturnToLoop1
    }

}