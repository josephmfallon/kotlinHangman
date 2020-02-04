package com.aevi.devportal

import com.aevi.devportal.buildings.House
import java.util.*

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
    @JvmStatic
    fun main(args: Array<String>) {
        val grid = Grid()
        grid.set(0, 1, XOChar.X)
    }
}