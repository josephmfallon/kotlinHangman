package com.aevi.devportal

import com.aevi.devportal.XOChar.EMPTY

class Grid {

    /*
        TODO check for out of bounds exceptions
     */

    private val tiles = arrayOf(
        arrayOf(EMPTY, EMPTY, EMPTY),
        arrayOf(EMPTY, EMPTY, EMPTY),
        arrayOf(EMPTY, EMPTY, EMPTY)
    )

    fun getFreeTiles(): List<Coordinate> {
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

    fun set(x: Int, y: Int, character: XOChar) {
        tiles[y][x] = character
    }

    fun setIfEmpty(x: Int, y: Int, character: XOChar): Boolean {
        if(get(x, y) == EMPTY) {
            set(x, y, character)
            return true
        } else {
            return false
        }
    }

    fun get(x: Int, y: Int): XOChar {
        return tiles[y][x]
    }

    fun display() {
        for(line in tiles.reversed()) {
            println(line.toList())
        }
    }

    fun reset() {
        for(rowIndex in tiles.indices) {
            val row = tiles[rowIndex]
            for(columnIndex in row.indices) {
                set(columnIndex, rowIndex, EMPTY)
            }
        }
    }
}