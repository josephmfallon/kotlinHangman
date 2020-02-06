package com.aevi.devportal

interface Grid {

    fun getFreeTiles(): List<Coordinate>

    fun set(x: Int, y: Int, character: XOChar)

    fun setIfEmpty(x: Int, y: Int, character: XOChar): Boolean

    fun get(x: Int, y: Int): XOChar

    fun display()

    fun reset()

    fun getWinner(): XOChar?
}