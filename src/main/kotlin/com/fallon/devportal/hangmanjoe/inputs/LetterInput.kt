package com.fallon.devportal.hangmanjoe.inputs

enum class LetterInput(val letter: Char) {
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E'),
    F('F'),
    G('G'),
    H('H'),
    I('I'),
    J('J'),
    K('K'),
    L('L'),
    M('M'),
    N('N'),
    O('O'),
    P('P'),
    Q('Q'),
    R('R'),
    S('S'),
    T('T'),
    U('U'),
    V('V'),
    W('W'),
    X('X'),
    Y('Y'),
    Z('Z'),
    Empty('-');

    override fun toString(): String {
        return letter.toString()
    }

    companion object {
        fun find(letter: Char?): LetterInput? {
            return values().firstOrNull {letterInput -> letterInput.letter == letter }
        }
    }
}