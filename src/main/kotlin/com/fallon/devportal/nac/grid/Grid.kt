package com.fallon.devportal.nac.grid

import com.fallon.devportal.nac.XOChar

interface Grid {

    fun getFreeTiles(): List<Coordinate>

    fun set(x: Int, y: Int, character: XOChar)

    fun setIfEmpty(x: Int, y: Int, character: XOChar): Boolean

    fun get(x: Int, y: Int): XOChar

    fun get(coordinate: Coordinate): XOChar
            = get(coordinate.x, coordinate.y)

    fun display()

    fun reset()

    fun getWinner(): XOChar?

    fun getTwoInARow(character: XOChar): Coordinate?
}