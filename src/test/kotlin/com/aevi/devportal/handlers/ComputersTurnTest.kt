package com.aevi.devportal.handlers

import com.aevi.devportal.*
import com.aevi.devportal.Main.selection
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