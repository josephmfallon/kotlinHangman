package com.aevi.devportal.handlers

import com.aevi.devportal.*
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class PlayersTurnTest : InputHandlerTester() {

    override val initialState = State.GameRound

    @RelaxedMockK
    lateinit var grid: Grid

    @BeforeEach
    fun setup() {
        handler = PlayersTurn(grid)
    }

    @Test
    fun `Winning coordinate input returns to loop 1`() {
        //Given
        Main.selection = XOChar.O
        every { grid.setIfEmpty(any(), any(), any()) } returns true
        every { grid.getWinner() } returns XOChar.O
        //When
        val result = handler.handleInput("1, 2")
        //Then
        assertEquals(InputResult.ContinueToNextHandler, result)
        verify {
            grid.setIfEmpty(1, 2, XOChar.O)
            grid.getWinner()
        }
    }

    @Test
    fun `Coordinate input continues to next handler`() {
        //Given
        Main.selection = XOChar.O
        every { grid.setIfEmpty(any(), any(), any()) } returns true
        every { grid.getWinner() } returns null
        //When
        val result = handler.handleInput("1, 0")
        //Then
        assertEquals(InputResult.ContinueToNextHandler, result)
        verify {
            grid.setIfEmpty(1, 0, XOChar.O)
            grid.getWinner()
        }
    }

    @TestFactory
    fun `Invalid inputs returns to loop 1`() =
        listOf("-1, 0", "3, 1")
            .map { input ->
                DynamicTest.dynamicTest("Invalid input \"${input}\"") {
                    //Given
                    Main.selection = XOChar.O
                    every { grid.setIfEmpty(any(), any(), any()) } returns false
                    //When
                    val result = handler.handleInput(input)
                    //Then
                    assertEquals(InputResult.ReturnToLoop1, result)
                }
            }
}