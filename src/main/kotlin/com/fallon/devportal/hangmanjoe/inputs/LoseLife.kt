package com.fallon.devportal.hangmanjoe.inputs

import com.fallon.devportal.hangmanjoe.gameResolutions
import com.fallon.devportal.hangmanjoe.linedisplay.LineDisplay


class LoseLife() {

    fun loseLife(playingWord: String, lettersTried: MutableList<Char> ,livesLeft: Int){
        var livesLeft = livesLeft
        if (livesLeft > 1) {
            livesLeft--
            LineDisplay().displayLine(playingWord, lettersTried)
            gameResolutions.livesLeft = livesLeft
            GamePrint.print("Letter Not Present in Word, You have lost a life. You have $livesLeft lives left.")
        } else {
            GameResolutions().gameEvaluation("LOSS")
        }
    }
}