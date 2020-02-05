package com.aevi.devportal.handlers

import com.aevi.devportal.InputHandler
import com.aevi.devportal.InputResult
import com.aevi.devportal.Main
import com.aevi.devportal.Main.state
import com.aevi.devportal.Main.won
import com.aevi.devportal.State

class ComputersTurn : InputHandler {

    override fun shouldHandle(): Boolean {
        return state == State.GameRound
    }

    override fun getQuestion(): String? {
        return null
    }

    override fun handleInput(string: String): InputResult {
        val freeTiles = Main.grid.getFreeTiles()
        if (freeTiles.isEmpty()) {
            //draw
            println("Draw!")
            //TODO("reset etc..")
            return InputResult.ContinueToNextHandler//FIXME
        } else {
            val (randomX, randomY) = freeTiles.random()
            Main.grid.set(randomX, randomY, Main.selection.opposite())
            Main.grid.display()
            println("Computer turn complete")
            val winner = Main.getWinner()
            won(winner)
            return InputResult.ReturnToLoop1//Doesn't matter
        }
    }
}