package com.aevi.devportal.nac.input.handlers

import com.aevi.devportal.nac.input.InputHandler
import com.aevi.devportal.nac.input.InputResult
import com.aevi.devportal.nac.NoughtsAndCrosses.state
import com.aevi.devportal.nac.State

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