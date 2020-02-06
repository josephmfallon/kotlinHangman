package com.aevi.devportal.nac.grid

import com.aevi.devportal.nac.XOChar

fun TileGrid.checkWinnerHorizontally(character: XOChar): Boolean {
    for (i in 0 until 3) {
        if (get(0, i) == character &&
            get(1, i) == character &&
            get(2, i) == character
        ) {
            return true
        }
    }
    return false
}

fun TileGrid.checkWinnerVertically(character: XOChar): Boolean {
    for (i in 0 until 3) {
        if (get(i, 0) == character &&
            get(i, 1) == character &&
            get(i, 2) == character
        ) {
            return true
        }
    }
    return false
}

fun TileGrid.checkWinnerDiagonally(character: XOChar): Boolean {
    if (get(0, 0) == character &&
        get(1, 1) == character &&
        get(2, 2) == character
    ) {
        return true
    }
    if (get(2, 0) == character &&
        get(1, 1) == character &&
        get(0, 2) == character
    ) {
        return true
    }
    return false
}

fun TileGrid.checkForTwoHorizontally(character: XOChar): Coordinate? {
    for (i in 0 until 3) {
        if (get(0, i) == character &&
            get(1, i) == character &&
            get(2, i) == XOChar.EMPTY
        ) {
            return Coordinate(2, i)
        }
        if (get(0, i) == XOChar.EMPTY &&
            get(1, i) == character &&
            get(2, i) == character
        ) {
            return Coordinate(0, i)
        }
    }
    return null
}

fun TileGrid.checkForTwoVertically(character: XOChar): Coordinate? {
    for (i in 0 until 3) {
        if (get(i, 0) == character &&
            get(i, 1) == character &&
            get(i, 2) == XOChar.EMPTY
        ) {
            return Coordinate(i, 2)
        }
        if (get(i, 0) == XOChar.EMPTY &&
            get(i, 1) == character &&
            get(i, 2) == character
        ) {
            return Coordinate(i, 0)
        }
    }
    return null
}

fun TileGrid.checkForTwoDiagonally(character: XOChar): Coordinate? {
    if (get(0, 0) == character &&
        get(1, 1) == character &&
        get(2, 2) == XOChar.EMPTY
    ) {
        return Coordinate(2, 2)
    }
    if (get(0, 0) == XOChar.EMPTY &&
        get(1, 1) == character &&
        get(2, 2) == character
    ) {
        return Coordinate(0, 0)
    }
    if (get(2, 0) == character &&
        get(1, 1) == character &&
        get(0, 2) == XOChar.EMPTY
    ) {
        return Coordinate(0, 2)
    }
    if (get(2, 0) == XOChar.EMPTY &&
        get(1, 1) == character &&
        get(0, 2) == character
    ) {
        return Coordinate(2, 0)
    }
    return null
}
