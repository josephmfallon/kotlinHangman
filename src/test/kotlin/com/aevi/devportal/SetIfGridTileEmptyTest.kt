package com.aevi.devportal

import org.junit.jupiter.api.Test

class SetIfGridTileEmptyTest {

    @Test
    fun `Set when tile empty`() {
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.EMPTY)
        //When
        val result = grid.setIfEmpty(0, 0, XOChar.X)
        //Then
        assert(result)
        assert(grid.get(0, 0) == XOChar.X)
    }

    @Test
    fun `Set when tile is set`() {
        //Given
        val grid = Grid()
        grid.set(0, 0, XOChar.O)
        //When
        val result = grid.setIfEmpty(0, 0, XOChar.X)
        //Then
        assert(!result)
        assert(grid.get(0, 0) == XOChar.O)
    }

}