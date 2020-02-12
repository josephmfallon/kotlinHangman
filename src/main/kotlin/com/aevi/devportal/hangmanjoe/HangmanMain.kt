package com.aevi.devportal.hangmanjoe

import com.aevi.devportal.hangmanjoe.inputs.LetterInput
import kotlin.random.Random

//Hangman
//Store a random array of words (hardcoded) !!!!
//Create function to select random word !!!!
// Create enum class to define Character Input types!!!!
//Create game states!!!!
//Create function which displays unguessed tiles as empty
//Create console interace for game to run in
//Each game a random word is selected and displays the empty characters.
//Player should be prompted to enter a character
//Correct characters should be filled in
//Incorrect characters should deduct a life
//The game is lost when no lives remain
//The game is won when the word is complete
//Incorrect characters entered twice shouldn't deduct two lives.
//The player should be able to reset and exit the game.

val InputWords = arrayOf<String>("SLEEP","DELETION","FRAGMENT","HEATING","FANG","ASHES","BLOB","FOOL","INVISIBLE","RING","BEHAVIOR","GESTURAL","CRITICAL","DESTRUCTIVE","LUSTRE","CREATIVE","SHRIMP","DEBAUCHERY","HORSERADISH","SWEAT","BLACKOUT","CHOKING","SHADOW","LUMINOUS","SAUCE","HAZY","TEN","LEGION","BEGGING","COWS")
val LivesLeft: Int = 8
fun selectRandomWord(Arrayofwords: Array<String>):String {
    val ranNum = Arrayofwords.indices.random()
    return Arrayofwords[ranNum]
}
val randomWord = selectRandomWord(InputWords)

//display unguessed tiles if game is ongoing or the initial empty tiles size for a new game
fun displayUnguessedTiles(randomWord: String): String {
    val returnTile: String = ""
    for (char in randomWord) {
        if (char.toString() != LetterInput.toString()) {
            returnTile.plus(LetterInput.Empty)
        } else {
            returnTile.plus(char)
        }
    }
    return returnTile
}


fun main(args: Array<String>) {




    println(displayUnguessedTiles(randomWord))
    println(randomWord)
    println(LetterInput.A)

    //logic of the game
    var isRunning = true

    while (isRunning){
        println("Test logic running")
        break
    }
}

/*for letter in ChosenWord
if letter == 'inputletter'
print letter at position of letter on console screen.
else {
    Logic that tells the user the letter isn't available and takes away a life
}
 */