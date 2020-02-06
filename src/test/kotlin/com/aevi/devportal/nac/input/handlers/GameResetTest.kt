package com.aevi.devportal.nac.input.handlers

import com.aevi.devportal.nac.NoughtsAndCrosses
import com.aevi.devportal.nac.State
import com.aevi.devportal.nac.XOChar
import com.aevi.devportal.nac.grid.Grid
import com.aevi.devportal.nac.input.InputHandlerTester
import com.aevi.devportal.nac.input.InputResult
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class GameResetTest : InputHandlerTester() {

    override val initialState = State.GameRound

    @RelaxedMockK
    lateinit var grid: Grid

    @BeforeEach
    fun setup() {
        handler = GameReset(grid)
    }

    @Test
    fun `Reset input returns to loop 1`() {
        //When
        val result = handler.handleInput("ReSeT")
        //Then
        verify {
            grid.reset()
            grid.display()
        }
        assert(result == InputResult.ReturnToLoop1)
    }

    @Test
    fun `Any input continues to next handler`() {
        //Given
        NoughtsAndCrosses.selection = XOChar.O
        //When
        val result = handler.handleInput("anything")
        //Then
        verify(exactly = 0) {
            grid.reset()
            grid.display()
        }
        assert(result == InputResult.ContinueToNextHandler)
    }
}