package com.aevi.devportal

object Main {
    /*
        Naughts and crosses

        Grid
        XOChar selection
        player always takes first turn
        player input
            coordinate for players turn
            reset
        Winning state
        Draw state
        Setting tile
            if tile set
                cant set
            else
                set
         Computer choice
            random
     */

    val state = State.CharacterSelection
    lateinit var selection: XOChar

    fun characterSelection(line: String): Boolean {
        if(state == State.CharacterSelection) {
            val character = line.toCharArray().first()
            if (character == XOChar.O.character || character == XOChar.X.character) {
                println("You have chosen $character")
                selection = XOChar.find(character)
            } else {
                System.err.println("Not a valid character.")
                println("Please choose a character 'X' or 'O'")
            }
            return true
        } else {
            return false
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        val grid = Grid()
//        grid.set(0, 1, XOChar.X)

        var isRunning = true

        println("Please choose a character 'X' or 'O'")

        while(isRunning) {
            val line = readLine()!!

            if(characterSelection(line)) {
                continue
            }
        }

    }
}