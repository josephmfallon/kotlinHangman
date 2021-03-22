package com.fallon.devportal.nac.input.handlers

import com.fallon.devportal.nac.NoughtsAndCrosses
import com.fallon.devportal.nac.State
import com.fallon.devportal.nac.XOChar
import com.fallon.devportal.nac.grid.Grid
import com.fallon.devportal.nac.input.InputHandlerTester
import com.fallon.devportal.nac.input.InputResult
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