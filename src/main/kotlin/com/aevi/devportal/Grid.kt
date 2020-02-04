package com.aevi.devportal

import com.aevi.devportal.XOChar.EMPTY

class Grid {
    private val tiles = arrayOf(
        arrayOf(EMPTY, EMPTY, EMPTY),
        arrayOf(EMPTY, EMPTY, EMPTY),
        arrayOf(EMPTY, EMPTY, EMPTY)
    )

    fun set(x: Int, y: Int, character: XOChar) {
        tiles[y][x] = character
    }

    fun get(x: Int, y: Int): XOChar {
        return tiles[y][x]
    }

    fun print() {
        for(line in tiles) {
            println(line.toList())
        }
    }
}