package com.fallon.devportal.nac.grid

import com.fallon.devportal.nac.XOChar
import org.junit.jupiter.api.Test

class SetIfTileGridTileEmptyTest {

    @Test
    fun `Set when tile empty`() {
        //Given
        val grid = TileGrid()
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
        val grid = TileGrid()
        grid.set(0, 0, XOChar.O)
        //When
        val result = grid.setIfEmpty(0, 0, XOChar.X)
        //Then
        assert(!result)
        assert(grid.get(0, 0) == XOChar.O)
    }

}