package com.aevi.devportal.handlers

import com.aevi.devportal.InputResult
import com.aevi.devportal.Main
import com.aevi.devportal.State
import com.aevi.devportal.XOChar
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameResetTest : InputHandlerTester() {

    override val initialState = State.GameRound

    @BeforeEach
    fun setup() {
        handler = GameReset()
    }

    @Test
    fun `Reset input returns to loop 1`() {
        //When
        val result = handler.handleInput("ReSeT")
        //Then
        assert(result == InputResult.ReturnToLoop1)
    }

    @Test
    fun `Any input continues to next handler`() {
        //Given
        Main.selection = XOChar.O
        //When
        val result = handler.handleInput("anything")
        //Then
        assert(result == InputResult.ContinueToNextHandler)
    }
}