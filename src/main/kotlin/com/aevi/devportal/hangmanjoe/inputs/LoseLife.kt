package com.aevi.devportal.hangmanjoe.inputs

import com.aevi.devportal.hangmanjoe.linedisplay.LineDisplay


class LoseLife() {

    fun loseLife(gameResolutions: GameResolutions) {
        var livesLeft = gameResolutions.livesLeft
        if (livesLeft > 1) {
            livesLeft--
            LineDisplay().displayLine(gameResolutions)
            GamePrint.print("Letter Not Present in Word, You have lost a life. You have $livesLeft lives left.")
        } else {
            GameResolutions().gameEvaluation("LOSS")
        }
    }
}