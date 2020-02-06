package com.aevi.devportal

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

abstract class InputHandlerTester {

    lateinit var handler: InputHandler

    abstract val initialState: State

    @Test
    fun `Should handle initial state`() {
        //Given
        Main.state = initialState
        //When
        val shouldHandle = handler.shouldHandle()
        //Then
        assert(shouldHandle)
    }

    @TestFactory
    fun `Should not handle other handlers`() = listOf(
        State.CharacterSelection,
        State.GameRound,
        State.GameOver,
        State.GameReset,
        State.Win,
        State.Lose
    )
        .filterNot { it == initialState }
        .map { state ->
            DynamicTest.dynamicTest("Should not handle ${state::class.java.simpleName}") {
                //Given
                Main.state = state
                //When
                val shouldHandle = handler.shouldHandle()
                //Then
                assert(!shouldHandle)
            }
        }
}