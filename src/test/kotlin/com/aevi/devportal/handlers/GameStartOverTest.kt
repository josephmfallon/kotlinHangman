package com.aevi.devportal.handlers

import com.aevi.devportal.InputResult
import com.aevi.devportal.Main
import com.aevi.devportal.State
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameStartOverTest : InputHandlerTester() {

    override val initialState = State.GameOver

    @BeforeEach
    fun setup() {
        handler = GameStartOver()
        Main.grid.reset()
    }

    @Test
    fun `Any input returns to loop one`() {
        //When
        val result = handler.handleInput("absolutely anything")
        //Then
        assertEquals(InputResult.ReturnToLoop1, result)
    }
}