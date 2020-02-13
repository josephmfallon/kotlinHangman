package com.aevi.devportal.hangmanjoe

//Hangman
//Store a random array of words (hardcoded) !!!!
//Create function to select random word !!!!
// Create enum class to define Character Input types!!!!
//Create game states!!!!
//Create function which displays unguessed tiles as empty !!!!
//Create console inteface for game to run in!!!!
//Each game a random word is selected and displays the empty characters.!!!!
//Player should be prompted to enter a character!!!!
//Correct characters should be filled in!!!!
//Incorrect characters should deduct a life!!!!
//The game is lost when no lives remain!!!!
//The game is won when the word is complete!!!!
//Incorrect characters entered twice shouldn't deduct two lives.
//The player should be able to reset and exit the game.
//Abstract everything into Classes

import com.aevi.devportal.hangmanjoe.inputs.GamePrint
import com.aevi.devportal.hangmanjoe.inputs.LetterInput
import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay
import javax.swing.text.StyledEditorKit

var livesLeft: Int = 8
lateinit var randomWord: String
lateinit var mutableWord: String
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

val doubleLetterWords = arrayOf<String>("BEER", "CHEER", "MOO", "GLASSES","FEELING","SPEAKER")

fun selectRandomWord(arrayofwords: Array<String>): String {
    val ranNum = arrayofwords.indices.random()
    return arrayofwords[ranNum]
}


//display unguessed tiles if game is ongoing or the initial empty tiles size for a new game
fun displayUnguessedTiles(mutableRandomWord: String): String {
    var returnTile = ""
    for (char in randomWord) {
        returnTile = if (char.toString() != LetterInput.toString()) {
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
    for ((charIndex, char) in randomWord.withIndex()) {
        if (char == letterValue.letter) { //only add char to first instance of itself in Word -> LUMINOUS -> -U------
            var wordAsArray = mutableWord.toCharArray()
            wordAsArray[charIndex] = letterValue.letter
            mutableWord = wordAsArray.joinToString(separator = "")
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
        loseLife()
    } else {
        if (!mutableWord.any { it == LetterInput.Empty.letter }) {
            playerWins()
        }
    }
}

fun loseLife() {
    if (livesLeft > 1) {
        livesLeft--
        LineDisplay.displayLine()
        GamePrint.print("Letter Not Present in Word, You have lost a life. You have $livesLeft lives left.")
    } else {
        playerLoses()
    }
}

fun playerLoses() {
    LineDisplay.displayLine()
    GamePrint.print("You have run out lives and therefore lost the game.")
    GameReset()
}

fun playerWins() {
    LineDisplay.displayLine()
    GamePrint.print("You have correctly guessed the word & Won!!")
    GameReset()
}

fun GameReset() {
    livesLeft = 8
    randomWord = selectRandomWord(inputWords)
    mutableWord = displayUnguessedTiles(randomWord)
    lettersTried.clear()
    GamePrint.print("Current Game Finished.")
    GamePrint.print("New Game beginning")
}

fun main(args: Array<String>) {
    randomWord = selectRandomWord(inputWords)
    //used as the source of truth comparison. mutableWord is the player game state
    mutableWord = displayUnguessedTiles(randomWord)
    lettersTried = mutableListOf()
    //initialised at start, changed throughout game


//    println("displayUnguessedTiles NoPlayerInput Example: " + displayUnguessedTiles(randomWord))
    println("Random Word chosen for first game: $randomWord")
//    println(mutableWord)
//    println(LetterInput.A)

    //logic of the game
    var isRunning = true


    while (isRunning) {//game logic loop
        GamePrint.print("Please enter an upper Case Letter")
        var playerInput: String = readLine()!!

        var charValid = isValidChar(playerInput)
//        LineDisplay.displayLine()
        decider(charValid)


    }
    readLine() //waits for user input before continuing
}
