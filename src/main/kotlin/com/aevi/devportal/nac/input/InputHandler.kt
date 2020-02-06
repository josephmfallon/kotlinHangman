package com.aevi.devportal.nac.input

interface InputHandler {

    fun shouldHandle(): Boolean

    fun getQuestion(): String?

    fun handleInput(string: String): InputResult
}