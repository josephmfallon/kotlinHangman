package com.aevi.devportal.nac

enum class XOChar(val character: Char) {
    O('O'),
    X('X'),
    EMPTY('-');


    fun opposite(): XOChar {
        if(this == O) {
            return X
        } else if(this == X) {
            return O
        } else {
            return EMPTY
        }
    }

    override fun toString(): String {
        return character.toString()
    }

    companion object {
        fun find(character: Char): XOChar {
            return values().first { xoChar -> xoChar.character == character }
        }
    }
}