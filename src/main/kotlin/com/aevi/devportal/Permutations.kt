package com.aevi.devportal


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


