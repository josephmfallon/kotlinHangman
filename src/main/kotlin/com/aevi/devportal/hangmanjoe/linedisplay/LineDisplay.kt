package com.aevi.devportal.hangmanjoe.linedisplay

import com.aevi.devportal.hangmanjoe.lettersTried
import com.aevi.devportal.hangmanjoe.playingWord

object LineDisplay{

    fun displayLine(){
        println("GAME LINE: $playingWord")
        println("Tally of letters guessed: $lettersTried")
    }
}