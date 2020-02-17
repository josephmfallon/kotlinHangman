package com.aevi.devportal.hangmanjoe.inputs

import com.aevi.devportal.hangmanjoe.lettersTried
import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay
import com.aevi.devportal.hangmanjoe.playingWord
import com.aevi.devportal.hangmanjoe.randomWordSelected

class LetterInputLogic() {

    fun isValidChar(playerInput: String): LetterInput? {
        val firstPlayerChar = playerInput.toUpperCase().toCharArray().firstOrNull()
        val playInEnum = LetterInput.find(firstPlayerChar)
        if (playInEnum == null) {
            GamePrint.print("Invalid Character please enter a Valid Character")
            return null //game logic will make player enter another value
        } else {
//        println("Char Valid, proceeding to next step")
            return playInEnum //game logic will check to see if character present in randomWord
        }
    }

    fun letterGuess(letterValue: LetterInput) {

        if(lettersTried.contains(letterValue.letter)){
            GamePrint.print("Character already entered within LettersTried: $lettersTried, please enter another.")
            LineDisplay().displayLine()
            return //if triggered ignores all steps after empty return
        }
        var anyCharCorrect: Boolean = false
        for ((charIndex, char) in randomWordSelected.withIndex()) {
            if (char == letterValue.letter) {
                var wordAsArray = playingWord.toCharArray()
                wordAsArray[charIndex] = letterValue.letter
                playingWord = wordAsArray.joinToString(separator = "")
                anyCharCorrect = true
            }
        } //end of "for" loop
        lettersTried.add(letterValue.letter)
        if(anyCharCorrect){
            GamePrint.print("Correct character chosen")
        }
        LineDisplay().displayLine()
        //If AnyCharCorrect is false will make player lose a life
        if (!anyCharCorrect) {
            LoseLife().loseLife()
        } else {
            if (!playingWord.any { it == LetterInput.Empty.letter }) {
                GameResolutions().playerWins()
            }
        }
    }

    fun decider(charValid: LetterInput?) {
        if (charValid != null) {
//        println("in Decider: Char is valid, executing ")
            LetterInputLogic().letterGuess(charValid)
        }
    } //if false will continue on through loop, or if nothing else present will restart loop
}