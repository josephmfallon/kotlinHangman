package com.aevi.devportal.handlers

import com.aevi.devportal.InputResult
import com.aevi.devportal.Main
import com.aevi.devportal.State
import com.aevi.devportal.XOChar
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ComputersTurnTest : InputHandlerTester() {

    override val initialState = State.GameRound

    @BeforeEach
    fun setup() {
        handler = ComputersTurn()
    }

    @Test
    fun `No free tiles returns continue`() {
        //Given
        for(x in 0 until 3) {
            for(y in 0 until 3) {
                Main.grid.set(x, y, XOChar.X)
            }
        }
        //When
        val result = handler.handleInput("")
        //Then
        assert(result == InputResult.ContinueToNextHandler)
    }

    @Test
    fun `Free tiles returns to loop 1`() {
        //Given
        Main.selection = XOChar.O
        //When
        val result = handler.handleInput("")
        //Then
        assert(result == InputResult.ReturnToLoop1)
    }
}