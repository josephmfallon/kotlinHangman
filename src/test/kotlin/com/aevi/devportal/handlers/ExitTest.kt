package com.aevi.devportal.handlers

import com.aevi.devportal.*
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class ExitTest {

    lateinit var handler: InputHandler

    @BeforeEach
    fun setup() {
        handler = Exit()
    }

    @Test
    fun `Exit stops game running`() {
        //Given
        Main.selection = XOChar.O
        //When
        val result = handler.handleInput("ExIt")
        //Then
        assertEquals(InputResult.StopRunning, result)
    }

    @Test
    fun `Anything else is ignored`() {
        //Given
        Main.selection = XOChar.O
        //When
        val result = handler.handleInput("anything")
        //Then
        assertEquals(InputResult.ContinueToNextHandler, result)
    }


    @Test
    fun `Should not handle character-selection state`() {
        //Given
        Main.state = State.CharacterSelection
        //When
        val shouldHandle = handler.shouldHandle()
        //Then
        assert(!shouldHandle)
    }

    @TestFactory
    fun `Should handle other handlers`() = listOf(
        State.GameRound,
        State.GameOver,
        State.GameReset,
        State.Win,
        State.Lose
    )
        .map { state ->
            DynamicTest.dynamicTest("Should not handle ${state::class.java.simpleName}") {
                //Given
                Main.state = state
                //When
                val shouldHandle = handler.shouldHandle()
                //Then
                assert(shouldHandle)
            }
        }
}