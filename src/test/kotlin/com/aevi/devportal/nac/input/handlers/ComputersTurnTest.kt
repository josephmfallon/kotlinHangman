package com.aevi.devportal.nac.input.handlers

import com.aevi.devportal.nac.NoughtsAndCrosses.selection
import com.aevi.devportal.nac.State
import com.aevi.devportal.nac.XOChar
import com.aevi.devportal.nac.grid.Coordinate
import com.aevi.devportal.nac.grid.Grid
import com.aevi.devportal.nac.input.InputHandlerTester
import com.aevi.devportal.nac.input.InputResult
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class ComputersTurnTest : InputHandlerTester() {

    override val initialState = State.GameRound

    @RelaxedMockK
    lateinit var grid: Grid

    @BeforeEach
    fun setup() {
        handler = ComputersTurn(grid)
    }

    @Test
    fun `No free tiles returns continue`() {
        //Given
        every { grid.getFreeTiles() } returns listOf()
        //When
        val result = handler.handleInput("")
        //Then
        assert(result == InputResult.ContinueToNextHandler)
        verify {
            grid.display()
        }
        verify(exactly = 0) {
            grid.set(1, 2,  XOChar.O)
            grid.getWinner()
        }
    }

    @Test
    fun `Free tiles returns to loop 1`() {
        //Given
        selection = XOChar.O
        every { grid.getFreeTiles() } returns listOf(Coordinate(1, 2))
        every { grid.getTwoInARow(any()) } returns null
        //When
        val result = handler.handleInput("1, 1")
        //Then
        assert(result == InputResult.ContinueToNextHandler)
        verify {
            grid.set(1, 2,  XOChar.X)
            grid.display()
            grid.getWinner()
        }
    }
}