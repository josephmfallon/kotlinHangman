package com.aevi.devportal.hangmanjoe.inputs

import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay
import com.aevi.devportal.hangmanjoe.livesLeft

class LoseLife() {

    fun loseLife() {
        if (livesLeft > 1) {
            livesLeft--
            LineDisplay.displayLine()
            GamePrint.print("Letter Not Present in Word, You have lost a life. You have $livesLeft lives left.")
        } else {
            GameResolutions().playerLoses()
        }
    }
}