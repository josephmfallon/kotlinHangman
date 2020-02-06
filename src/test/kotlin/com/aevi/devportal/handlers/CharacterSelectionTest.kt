package com.aevi.devportal.handlers

import com.aevi.devportal.*
import com.aevi.devportal.Main.selection
import com.aevi.devportal.Main.state
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class CharacterSelectionTest : InputHandlerTester() {

    override val initialState = State.CharacterSelection

    @RelaxedMockK
    lateinit var grid: Grid

    @BeforeEach
    fun setup() {
        handler = CharacterSelection(grid)
    }

    @TestFactory
    fun `Valid input sets selection, state and displays grid`() =
        mapOf(
            "X" to InputResult.ReturnToLoop1,
            "O" to InputResult.ReturnToLoop1
        ).map {
            dynamicTest("Handle ${it.key}") {
                //When
                selection = XOChar.O
                val whichResult = handler.handleInput(it.key)
                //Then
                verify {
                    grid.display()
                }
                assert(whichResult == it.value)
                assertEquals(State.GameRound, state)
            }
        }

    @TestFactory
    fun `Invalid input`() =
        mapOf(
            "Z" to InputResult.InvalidInput,
            "-" to InputResult.InvalidInput
        ).map {
            dynamicTest("Handle ${it.key}") {
                //When
                selection = XOChar.O
                val whichResult = handler.handleInput(it.key)
                //Then
                verify(exactly = 0) { grid.display() }
                assert(whichResult == it.value)
                assertNotEquals(State.CharacterSelection, state)
                assertEquals(XOChar.O, selection)
            }
        }

}