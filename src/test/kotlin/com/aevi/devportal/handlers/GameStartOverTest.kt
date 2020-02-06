package com.aevi.devportal.handlers

import com.aevi.devportal.*
import com.aevi.devportal.Main.state
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