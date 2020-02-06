package com.aevi.devportal.nac.input.handlers

import com.aevi.devportal.nac.grid.Grid
import com.aevi.devportal.nac.input.InputHandler
import com.aevi.devportal.nac.input.InputResult
import com.aevi.devportal.nac.NoughtsAndCrosses.state
import com.aevi.devportal.nac.State

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