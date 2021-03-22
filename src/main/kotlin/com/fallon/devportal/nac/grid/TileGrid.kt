package com.fallon.devportal.nac.grid

import com.fallon.devportal.nac.XOChar
import com.fallon.devportal.nac.XOChar.EMPTY

/**
 * TODO handle out of bounds exceptions
 */
class TileGrid : Grid {

    private val tiles = arrayOf(
        arrayOf(EMPTY, EMPTY, EMPTY),
        arrayOf(EMPTY, EMPTY, EMPTY),
        arrayOf(EMPTY, EMPTY, EMPTY)
    )

    override fun getFreeTiles(): List<Coordinate> {
        val list = mutableListOf<Coordinate>()
        for(rowIndex in tiles.indices) {
            val row = tiles[rowIndex]
            for(columnIndex in row.indices) {
                if(get(columnIndex, rowIndex) == EMPTY) {
                    list.add(Coordinate(columnIndex, rowIndex))
                }
            }
        }
        return list
    }

    override fun set(x: Int, y: Int, character: XOChar) {
        tiles[y][x] = character
    }

    override fun setIfEmpty(x: Int, y: Int, character: XOChar): Boolean {
        if(get(x, y) == EMPTY) {
            set(x, y, character)
            return true
        } else {
            return false
        }
    }

    override fun get(x: Int, y: Int): XOChar {
        return tiles[y][x]
    }

    override fun display() {
        for(line in tiles.reversed()) {
            println(line.toList())
        }
    }

    override fun reset() {
        for(rowIndex in tiles.indices) {
            val row = tiles[rowIndex]
            for(columnIndex in row.indices) {
                set(columnIndex, rowIndex, EMPTY)
            }
        }
    }

    private fun getWinner(character: XOChar): Boolean {
        if(checkWinnerHorizontally(character)) {
            return true
        }
        if(checkWinnerVertically(character)) {
            return true
        }
        if(checkWinnerDiagonally(character)) {
            return true
        }
        return false
    }

    override fun getWinner(): XOChar? {
        if(getWinner(XOChar.X)) {
            return XOChar.X
        }
        if(getWinner(XOChar.O)) {
            return XOChar.O
        }
        return null
    }

    override fun getTwoInARow(character: XOChar): Coordinate? {
        val horizontal = checkForTwoHorizontally(character)
        if(horizontal != null) {
            return horizontal
        }
        val vertical = checkForTwoVertically(character)
        if(vertical != null) {
            return vertical
        }
        val diagonal = checkForTwoDiagonally(character)
        if(diagonal != null) {
            return diagonal
        }
        return null
    }
}