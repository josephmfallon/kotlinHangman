package com.aevi.devportal

interface InputHandler {

    fun shouldHandle(): Boolean

    fun getQuestion(): String?

    fun handleInput(string: String): InputResult
}