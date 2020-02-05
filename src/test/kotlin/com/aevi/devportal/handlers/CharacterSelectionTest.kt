package com.aevi.devportal.handlers

import com.aevi.devportal.InputResult
import com.aevi.devportal.Main
import com.aevi.devportal.State
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class CharacterSelectionTest {

    lateinit var handler: CharacterSelection

    @BeforeEach
    fun setup() {
        handler = CharacterSelection()
    }

    @Test
    fun `Should handle character selection`() {
        //Given
        Main.state = State.CharacterSelection
        //When
        val shouldHandle = handler.shouldHandle()
        //Then
        assert(shouldHandle)
    }

    fun shouldNotHandleOtherStatesTest(excludedState: State): List<DynamicTest> {
        val allStates = listOf(
            State.CharacterSelection,
            State.GameRound,
            State.GameOver,
            State.GameReset
        )

        val allExceptExcludedStates = allStates.filterNot { it == excludedState }
        return allExceptExcludedStates.map { state ->
            dynamicTest("Should not handle ${state::class.java.simpleName}") {
                //Given
                Main.state = state
                //When
                val shouldHandle = handler.shouldHandle()
                //Then
                assert(!shouldHandle)
            }
        }
    }

    @TestFactory
    fun `Should not handle non-character-selection handlers`() =
        shouldNotHandleOtherStatesTest(State.CharacterSelection)


    @TestFactory
    fun `Test handle input`() =
        mapOf(
            "X" to InputResult.ReturnToLoop1,
            "O" to InputResult.ReturnToLoop1,
            "Z" to InputResult.InvalidInput
        ).map {
            dynamicTest("Handle ${it.key}") {
                //When
                val whichResult = handler.handleInput(it.key)
                //Then
                assert(whichResult == it.value)
            }
        }
}