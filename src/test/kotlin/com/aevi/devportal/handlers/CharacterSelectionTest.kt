package com.aevi.devportal.handlers

import com.aevi.devportal.InputResult
import com.aevi.devportal.State
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class CharacterSelectionTest : InputHandlerTester() {

    override val initialState = State.CharacterSelection

    @BeforeEach
    fun setup() {
        handler = CharacterSelection()
    }

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