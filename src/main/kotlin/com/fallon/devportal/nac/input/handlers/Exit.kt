package com.fallon.devportal.nac.input.handlers

import com.fallon.devportal.nac.input.InputHandler
import com.fallon.devportal.nac.input.InputResult
import com.fallon.devportal.nac.NoughtsAndCrosses.state
import com.fallon.devportal.nac.State

class Exit : InputHandler {

    override fun shouldHandle(): Boolean {
        return state != State.CharacterSelection
    }

    override fun getQuestion(): String? {
        return null
    }

    override fun handleInput(string: String): InputResult {
        if(string.equals("exit", true)) {
            println("Goodbye!")
            return InputResult.StopRunning
        }
        return InputResult.ContinueToNextHandler
    }

}