package com.aevi.devportal.handlers

import com.aevi.devportal.*
import com.aevi.devportal.Main.selection
import com.aevi.devportal.Main.state

class ComputersTurn(private val grid: Grid) : InputHandler {

    override fun shouldHandle(): Boolean {
        return state == State.GameRound
    }

    override fun getQuestion(): String? {
        return null
    }

    override fun handleInput(string: String): InputResult {
        val freeTiles = grid.getFreeTiles()
        if (freeTiles.isEmpty()) {
            state = State.GameOver
            grid.display()
            println("Draw! Nobody has won.")
        } else {
            val (randomX, randomY) = freeTiles.random()
            grid.set(randomX, randomY, Main.selection.opposite())
            grid.display()
            println("Computer turn complete")
            val winner = grid.getWinner()
            if(winner != null) {
                state = if (winner == selection) State.Win else State.Lose
            }
        }
        return InputResult.ContinueToNextHandler
    }
}