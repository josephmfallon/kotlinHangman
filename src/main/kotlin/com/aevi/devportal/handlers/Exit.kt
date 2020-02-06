package com.aevi.devportal.handlers

import com.aevi.devportal.InputHandler
import com.aevi.devportal.InputResult
import com.aevi.devportal.Main.state
import com.aevi.devportal.State

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