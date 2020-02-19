package com.aevi.devportal.hangmanjoe.inputs

import com.aevi.devportal.hangmanjoe.*
import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay

class GameResolutions() {
    var livesLeft:Int = -1
    lateinit var randomWordSelected: String
    lateinit var playingWord: String
    lateinit var lettersTried: MutableList<Char>

    fun gameEvaluation(winState: String) {
        if (winState == "WIN") {
            this.gameReset("Current Game Finished. You have correctly guessed the word & Won!!")
        } else {
            this.gameReset(("Current Game Finished. You have run out lives and therefore lost the game."))
        }
    }

    fun gameReset(winState: String = "") {
        livesLeft = 8
        randomWordSelected = inputWords.random()
        playingWord = LineDisplay().displayUnguessedTiles(randomWordSelected)
        lettersTried = mutableListOf()
        GamePrint.print("$winState New Game beginning.")
        println("Random Word chosen for game: $randomWordSelected") //debug command
    }

    fun playerRestart(playerInput: String): Boolean {
        if (playerInput.toUpperCase() == "RESTART") {
            gameReset("Game Restarted.")
            return true
        } else return false
    }

    fun playerExit(playerInput: String):Boolean {
        if (playerInput.toUpperCase() == "EXIT") {
            GamePrint.print("Game Exiting")
            return true
        } else return false
    }
}