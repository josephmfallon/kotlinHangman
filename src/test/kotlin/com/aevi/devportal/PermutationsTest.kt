package com.aevi.devportal

import org.junit.jupiter.api.Test

internal class PermutationsTest {

    @Test
    fun `Horizontal all match X`() {//TODO parameterized
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.X)
        grid.set(1, 0, XOChar.X)
        grid.set(2, 0, XOChar.X)
        //When
        val result = grid.checkWinnerHorizontally(XOChar.X)
        //Then
        assert(result)
    }

    @Test
    fun `Horizontal all match O`() {
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.O)
        grid.set(1, 0, XOChar.O)
        grid.set(2, 0, XOChar.O)
        //When
        val result = grid.checkWinnerHorizontally(XOChar.O)
        //Then
        assert(result)
    }

    @Test
    fun `Vertical all match X`() {//TODO parameterized
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.X)
        grid.set(0, 1, XOChar.X)
        grid.set(0, 2, XOChar.X)
        //When
        val result = grid.checkWinnerVertically(XOChar.X)
        //Then
        assert(result)
    }

    @Test
    fun `Vertical all match O`() {
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.O)
        grid.set(0, 1, XOChar.O)
        grid.set(0, 2, XOChar.O)
        //When
        val result = grid.checkWinnerVertically(XOChar.O)
        //Then
        assert(result)
    }

    @Test
    fun `Diagonal north-east all match X`() {
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.X)
        grid.set(1, 1, XOChar.X)
        grid.set(2, 2, XOChar.X)
        //When
        val result = grid.checkWinnerDiagonally(XOChar.X)
        //Then
        assert(result)
    }

    @Test
    fun `Diagonal north-east all match O`() {
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.O)
        grid.set(1, 1, XOChar.O)
        grid.set(2, 2, XOChar.O)
        //When
        val result = grid.checkWinnerDiagonally(XOChar.O)
        //Then
        assert(result)
    }

    @Test
    fun `Diagonal north-west all match X`() {
        //Given
        val grid = Grid()
        grid.set(2, 0, XOChar.X)
        grid.set(1, 1, XOChar.X)
        grid.set(0, 2, XOChar.X)
        //When
        val result = grid.checkWinnerDiagonally(XOChar.X)
        //Then
        assert(result)
    }

    @Test
    fun `Diagonal north-west all match O`() {
        //Given
        val grid = Grid()
        grid.set(2, 0, XOChar.O)
        grid.set(1, 1, XOChar.O)
        grid.set(0, 2, XOChar.O)
        //When
        val result = grid.checkWinnerDiagonally(XOChar.O)
        //Then
        assert(result)
    }
}