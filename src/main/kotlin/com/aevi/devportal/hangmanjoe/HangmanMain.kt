package com.aevi.devportal.hangmanjoe


//The player should be able to reset and exit the game.
//Abstract everything into Classes
//Write tests for everything

import com.aevi.devportal.hangmanjoe.inputs.GamePrint
import com.aevi.devportal.hangmanjoe.inputs.GameResolutions
import com.aevi.devportal.hangmanjoe.inputs.LetterInput
import com.aevi.devportal.hangmanjoe.inputs.LoseLife
import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay

var livesLeft: Int = 8 //TODO change to lateinit (figure out why it doesn't work
lateinit var randomWordSelected: String
lateinit var playingWord: String
lateinit var lettersTried: MutableList<Char>
val inputWords = arrayOf<String>(
    "SLEEP",
    "DELETION",
    "FRAGMENT",
    "HEATING",
    "FANG",
    "ASHES",
    "BLOB",
    "FOOL",
    "INVISIBLE",
    "RING",
    "BEHAVIOR",
    "GESTURAL",
    "CRITICAL",
    "DESTRUCTIVE",
    "LUSTRE",
    "CREATIVE",
    "SHRIMP",
    "DEBAUCHERY",
    "HORSERADISH",
    "SWEAT",
    "BLACKOUT",
    "CHOKING",
    "SHADOW",
    "LUMINOUS",
    "SAUCE",
    "HAZY",
    "TEN",
    "LEGION",
    "BEGGING",
    "COWS"
)

fun selectRandomWord(arrayOfWords: Array<String>): String {
    val ranNum = arrayOfWords.indices.random()
    return arrayOfWords[ranNum]
}


//display unguessed tiles if game is ongoing or the initial empty tiles size for a new game
fun displayUnguessedTiles(): String {
    var returnTile = ""
    for (char in randomWordSelected) {
        returnTile = if (char.toString() != LetterInput.toString()) { //FIXME use .any instead of LetterInput.toString
//            !playingWord.any { it == LetterInput.Empty.letter }) maybe similar to this
            returnTile.plus(LetterInput.Empty)
        } else {
            returnTile.plus(char)
        }
    }
    return returnTile
}// for each round save return to the game state/ word-variable


fun isValidChar(playerInput: String): LetterInput? {
    val firstPlayerChar = playerInput.toCharArray().firstOrNull()
    val playInEnum = LetterInput.find(firstPlayerChar)
    if (playInEnum == null) {
        GamePrint.print("Invalid Character please enter a Valid Character")
        return null //game logic will make player enter another value
    } else {
//        println("Char Valid, proceeding to next step")
        return playInEnum //game logic will check to see if character present in randomWord
    }
}

fun decider(charValid: LetterInput?) {
    if (charValid != null) {
//        println("in Decider: Char is valid, executing ")
        letterGuess(charValid)
    }
} //if false will continue on through loop, or if nothing else present will restart loop

fun letterGuess(letterValue: LetterInput) {

    if(lettersTried.contains(letterValue.letter)){
        GamePrint.print("Character already entered within LettersTried: $lettersTried, please enter another.")
        LineDisplay.displayLine()
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
    LineDisplay.displayLine()
    //If AnyCharCorrect is false will make player lose a life
    if (!anyCharCorrect) {
        LoseLife().loseLife()
    } else {
        if (!playingWord.any { it == LetterInput.Empty.letter }) {
            GameResolutions().playerWins()
        }
    }
}

//fun loseLife() {
//    if (livesLeft > 1) {
//        livesLeft--
//        LineDisplay.displayLine()
//        GamePrint.print("Letter Not Present in Word, You have lost a life. You have $livesLeft lives left.")
//    } else {
//        GameResolutions().playerLoses()
//    }
//}

fun main(args: Array<String>) {
    GameResolutions().gameReset()

    //logic of the game
    var isRunning = true


    while (isRunning) {//game logic loop
        GamePrint.print("Please enter an upper Case Letter")
        var playerInput: String = readLine()!!

        var charValid = isValidChar(playerInput)
//        LineDisplay.displayLine()
        decider(charValid)
    }
//    readLine() //waits for user input before continuing
    readLine()
}
