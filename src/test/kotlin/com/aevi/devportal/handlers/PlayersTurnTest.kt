package com.aevi.devportal.handlers

import com.aevi.devportal.InputResult
import com.aevi.devportal.Main
import com.aevi.devportal.State
import com.aevi.devportal.XOChar
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class PlayersTurnTest : InputHandlerTester() {

    override val initialState = State.GameRound

    @BeforeEach
    fun setup() {
        handler = PlayersTurn()
        Main.grid.reset()
    }

    @Test
    fun `Winning coordinate input returns to loop 1`() {
        //Given
        Main.selection = XOChar.O
        Main.grid.set(0, 0, XOChar.O)
        Main.grid.set(1, 0, XOChar.O)
        //When
        val result = handler.handleInput("2, 0")
        //Then
        assertEquals(InputResult.ReturnToLoop1, result)
    }

    @Test
    fun `Coordinate input continues to next handler`() {
        //Given
        Main.selection = XOChar.O
        //When
        val result = handler.handleInput("1, 0")
        //Then
        assertEquals(InputResult.ContinueToNextHandler, result)
    }

    @TestFactory
    fun `Invalid inputs returns to loop 1`() =
        listOf("-1, 0", "3, 1")
            .map { input ->
                DynamicTest.dynamicTest("Invalid input \"${input}\"") {
                    //Given
                    Main.selection = XOChar.O
                    //When
                    val result = handler.handleInput(input)
                    //Then
                    assertEquals(InputResult.ReturnToLoop1, result)
                }
            }
}