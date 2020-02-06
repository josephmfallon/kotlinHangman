package com.aevi.devportal.nac.input.handlers

import com.aevi.devportal.nac.grid.Grid
import com.aevi.devportal.nac.input.InputHandler
import com.aevi.devportal.nac.input.InputResult
import com.aevi.devportal.nac.NoughtsAndCrosses.selection
import com.aevi.devportal.nac.NoughtsAndCrosses.state
import com.aevi.devportal.nac.State

class ComputersTurn(private val grid: Grid) : InputHandler {

    override fun shouldHandle(): Boolean {
        return state == State.GameRound
    }

    override fun getQuestion(): String? {
        return null
    }

    override fun handleInput(string: String): InputResult {
        val freeTiles = grid.getFreeTiles().toMutableList()
        if (freeTiles.isNotEmpty()) {
            val winningTile = grid.getTwoInARow(selection.opposite())
            val blockingTile = grid.getTwoInARow(selection)

            val tileToPlay = when {
                winningTile != null -> winningTile
                blockingTile != null -> blockingTile
                else -> freeTiles.random()
            }
            val (randomX, randomY) = tileToPlay

            grid.set(randomX, randomY, selection.opposite())
            grid.display()
            freeTiles.remove(tileToPlay)

            println("Computer turn complete")
            val winner = grid.getWinner()
            if(winner != null) {
                state = if (winner == selection) State.Win else State.Lose
            }
        }

        if(freeTiles.isEmpty()){
            state = State.GameOver
            grid.display()
            println("Draw! Nobody has won.")
        }
        return InputResult.ContinueToNextHandler
    }

}