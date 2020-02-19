package com.aevi.devportal.hangmanjoe


//The player should be able to reset and exit the game.
//Abstract everything into Classes
//Write tests for everything

import com.aevi.devportal.hangmanjoe.inputs.*
import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay
import kotlin.properties.Delegates

//var livesLeft by Delegates.notNull<Int>()
//lateinit var randomWordSelected: String
//lateinit var playingWord: String
//lateinit var lettersTried: MutableList<Char>
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
var lineDisplay = LineDisplay()

fun main(args: Array<String>) {
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
            isRunning = false
            break
        }
        letterInputLogic.decider(charValid)
    }
}
