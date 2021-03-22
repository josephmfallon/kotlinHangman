package com.fallon.devportal.nac.input.handlers

import com.fallon.devportal.nac.NoughtsAndCrosses.state
import com.fallon.devportal.nac.State
import com.fallon.devportal.nac.XOChar
import com.fallon.devportal.nac.grid.Grid
import com.fallon.devportal.nac.input.InputHandlerTester
import com.fallon.devportal.nac.input.InputResult
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class GameStartOverTest : InputHandlerTester() {

    override val initialState = State.GameOver

    @RelaxedMockK
    lateinit var grid: Grid

    @BeforeEach
    fun setup() {
        handler = GameStartOver(grid)
        every { grid.get(any(), any()) } returns XOChar.X
    }

    @Test
    fun `Check grid is reset, displayed and state is changed`() {
        //When
        handler.handleInput("anything")
        //Then
        verify {
            grid.reset()
            grid.display()
        }
        assertEquals(State.GameRound, state)
    }

    @Test
    fun `Any input returns to loop one`() {
        //When
        val result = handler.handleInput("absolutely anything")
        //Then
        assertEquals(InputResult.ReturnToLoop1, result)
    }
}