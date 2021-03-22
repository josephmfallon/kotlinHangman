package com.fallon.devportal.hangmanjoe


//The player should be able to reset and exit the game.
//Abstract everything into Classes
//Write tests for everything

import com.fallon.devportal.hangmanjoe.inputs.*

//var livesLeft:Int = -1
//lateinit var randomWordSelected: String
//lateinit var playingWord: String
//lateinit var lettersTried: MutableList<Char>
//put into gameResolutions class
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
val letterInputLogic = LetterInputLogic()
val gameResolutions = GameResolutions()

fun main(args: Array<String>) {
//
//    val arrayOfInputHandlers = arrayOf(
//        GameStart,
//        GameState.GameRound
//
//
//
//    )



    //logic of the game
    var isRunning = true

    gameResolutions.gameReset()

    start@ while (isRunning) {//game logic loop
        GamePrint.print("Please enter an upper Case Letter")
        var playerInput: String = readLine()!!

        var charValid = letterInputLogic.isValidChar(playerInput)
        if (gameResolutions.playerRestart(playerInput)) {
            continue@start
        }
        if (gameResolutions.playerExit(playerInput)) {
            break
        }
        letterInputLogic.decider(charValid, letterInputLogic)
    }
}
