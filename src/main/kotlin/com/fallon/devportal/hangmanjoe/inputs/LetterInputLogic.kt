package com.fallon.devportal.hangmanjoe.inputs


import com.fallon.devportal.hangmanjoe.gameResolutions
import com.fallon.devportal.hangmanjoe.linedisplay.LineDisplay


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

    fun letterGuess(letterValue: LetterInput, gameResolutions: GameResolutions) {
        var lettersTried = gameResolutions.lettersTried
        var randomWordSelected = gameResolutions.randomWordSelected
        var playingWord = gameResolutions.playingWord
        var livesLeft = gameResolutions.livesLeft

        if(lettersTried.contains(letterValue.letter)){
            GamePrint.print("Character already entered within LettersTried: $lettersTried, please enter another.")
            LineDisplay().displayLine(playingWord, lettersTried)
            return //if triggered ignores all steps after empty return
        }
        var anyCharCorrect: Boolean = false
        for ((charIndex, char) in randomWordSelected.withIndex()) {
            if (char == letterValue.letter) {
                var wordAsArray = playingWord.toCharArray()
                wordAsArray[charIndex] = letterValue.letter
                playingWord = wordAsArray.joinToString(separator = "")
                gameResolutions.playingWord = playingWord
                anyCharCorrect = true
            }
        } //end of "for" loop
        lettersTried.add(letterValue.letter)
        if(anyCharCorrect){
            GamePrint.print("Correct character chosen")
        }
        LineDisplay().displayLine(playingWord, lettersTried)
        //If AnyCharCorrect is false will make player lose a life
        if (!anyCharCorrect) {
            LoseLife().loseLife(playingWord,lettersTried,livesLeft)
        } else {
            if (!playingWord.any { it == LetterInput.Empty.letter }) {
                GameResolutions().gameEvaluation("WIN")
            }
        }
    }

    fun decider(charValid: LetterInput?,letterInputLogic: LetterInputLogic ) {
        if (charValid != null) {
//        println("in Decider: Char is valid, executing ")
            letterInputLogic.letterGuess(charValid, gameResolutions)
        }
    } //if false will continue on through loop, or if nothing else present will restart loop
}