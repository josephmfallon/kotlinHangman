package com.fallon.devportal.nac.grid

import com.fallon.devportal.nac.XOChar
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class PermutationsTest {

    @TestFactory
    fun `Horizontal all match`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Horizontal all match ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(0, 0, character)
            grid.set(1, 0, character)
            grid.set(2, 0, character)
            //When
            val result = grid.checkWinnerHorizontally(character)
            //Then
            assert(result)
        }
    }

    @TestFactory
    fun `Vertical all match`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Vertical all match ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(0, 0, character)
            grid.set(0, 1, character)
            grid.set(0, 2, character)
            //When
            val result = grid.checkWinnerVertically(character)
            //Then
            assert(result)
        }
    }

    @TestFactory
    fun `Diagonal north-east all match`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Diagonal north-east all match ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(0, 0, character)
            grid.set(1, 1, character)
            grid.set(2, 2, character)
            //When
            val result = grid.checkWinnerDiagonally(character)
            //Then
            assert(result)
        }
    }

    @TestFactory
    fun `Diagonal north-west all match`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Diagonal north-west all match ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(2, 0, character)
            grid.set(1, 1, character)
            grid.set(0, 2, character)
            //When
            val result = grid.checkWinnerDiagonally(character)
            //Then
            assert(result)
        }
    }

    /* For Two */

    @TestFactory
    fun `Horizontal match first`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Horizontal match first ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(0, 0, character)
            grid.set(1, 0, character)
            //When
            val result = grid.checkForTwoHorizontally(character)
            //Then
            assertNotNull(result)
            assertEquals(2, result!!.x)
            assertEquals(0, result.y)
        }
    }

    @TestFactory
    fun `Horizontal match last`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Horizontal match last ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(1, 0, character)
            grid.set(2, 0, character)
            //When
            val result = grid.checkForTwoHorizontally(character)
            //Then
            assertNotNull(result)
            assertEquals(0, result!!.x)
            assertEquals(0, result.y)
        }
    }

    @TestFactory
    fun `Vertical match first`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Vertical match first ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(0, 0, character)
            grid.set(0, 1, character)
            //When
            val result = grid.checkForTwoVertically(character)
            //Then
            assertNotNull(result)
            assertEquals(0, result!!.x)
            assertEquals(2, result.y)
        }
    }

    @TestFactory
    fun `Vertical match last`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Vertical match last ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(0, 1, character)
            grid.set(0, 2, character)
            //When
            val result = grid.checkForTwoVertically(character)
            //Then
            assertNotNull(result)
            assertEquals(0, result!!.x)
            assertEquals(0, result.y)
        }
    }

    @TestFactory
    fun `Diagonal north-east match first`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Diagonal north-east match first ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(0, 0, character)
            grid.set(1, 1, character)
            //When
            val result = grid.checkForTwoDiagonally(character)
            //Then
            assertNotNull(result)
            assertEquals(2, result!!.x)
            assertEquals(2, result.y)
        }
    }

    @TestFactory
    fun `Diagonal north-east match last`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Diagonal north-east match last ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(1, 1, character)
            grid.set(2, 2, character)
            //When
            val result = grid.checkForTwoDiagonally(character)
            //Then
            assertNotNull(result)
            assertEquals(0, result!!.x)
            assertEquals(0, result.y)
        }
    }

    @TestFactory
    fun `Diagonal north-west match first`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Diagonal north-west match first ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(2, 0, character)
            grid.set(1, 1, character)
            //When
            val result = grid.checkForTwoDiagonally(character)
            //Then
            assertNotNull(result)
            assertEquals(0, result!!.x)
            assertEquals(2, result.y)
        }
    }

    @TestFactory
    fun `Diagonal north-west match last`() = listOf(XOChar.X, XOChar.O).map { character ->
        dynamicTest("Diagonal north-west match last ${character.character}") {
            //Given
            val grid = TileGrid()
            grid.set(1, 1, character)
            grid.set(0, 2, character)
            //When
            val result = grid.checkForTwoDiagonally(character)
            //Then
            assertNotNull(result)
            assertEquals(2, result!!.x)
            assertEquals(0, result.y)
        }
    }
}