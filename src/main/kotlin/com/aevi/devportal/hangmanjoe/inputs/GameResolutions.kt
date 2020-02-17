package com.aevi.devportal.hangmanjoe.inputs

import com.aevi.devportal.hangmanjoe.*
import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay

class GameResolutions() {

    fun playerLoses() {
        LineDisplay().displayLine()
        this.gameReset(("Current Game Finished. You have run out lives and therefore lost the game."))
    }
    //very similar methods could be abstracted into same method. Is good or not? TODO
    fun playerWins() {
        this.gameReset("Current Game Finished. You have correctly guessed the word & Won!!")
    }

    fun gameReset(winState: String = "") {
        livesLeft = 8
        randomWordSelected = inputWords.random()
        playingWord = LineDisplay().displayUnguessedTiles()
        lettersTried = mutableListOf()
        GamePrint.print("$winState New Game beginning.")
        println("Random Word chosen for game: $randomWordSelected") //debug command
    }

}