package com.aevi.devportal

enum class XOChar(val character: Char) {
    O('0'),
    X('X'),
    EMPTY('-');

    companion object {
        fun find(character: Char): XOChar {
            return values().first { xoChar -> xoChar.character == character }
        }
    }
}