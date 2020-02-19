package com.aevi.devportal.hangmanjoe.linedisplay

import com.aevi.devportal.hangmanjoe.inputs.GameResolutions
import com.aevi.devportal.hangmanjoe.inputs.LetterInput

class LineDisplay{

    fun displayLine(gameResolutions: GameResolutions){
        var lettersTried = gameResolutions.lettersTried
        var playingWord = gameResolutions.playingWord

        println("GAME LINE: $playingWord")
        println("Tally of letters guessed: $lettersTried")
    }

    //display unguessed tiles if game is ongoing or the initial empty tiles size for a new game
    fun displayUnguessedTiles(gameResolutions: GameResolutions): String {
        var randomWordSelected =gameResolutions.randomWordSelected
        var returnTile = ""
        for (char in randomWordSelected) {
            if (char  != LetterInput.Empty.letter) {
//if any character within randomWordSelected doesn't equal a character within LetterInput - the type- then it should be added to the returnTile String, if it is found then that character should be added instead.
                returnTile += LetterInput.Empty
            } else {
                returnTile += char
            }
        }
        return returnTile
    }// for each round save return to the game state/ word-variable
}