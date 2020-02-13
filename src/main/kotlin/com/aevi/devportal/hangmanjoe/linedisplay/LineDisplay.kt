package com.aevi.devportal.hangmanjoe.linedisplay

import com.aevi.devportal.hangmanjoe.lettersTried
import com.aevi.devportal.hangmanjoe.mutableWord

object LineDisplay{

    fun displayLine(){
        println("GAME LINE: $mutableWord")
        println("Tally of letters guessed: $lettersTried")
    }
}