package com.aevi.devportal.hangmanjoe.inputs


//The states that a game can enter.
sealed class GameState {
    object WordSelection: GameState()
    object GameRound: GameState()
    object GameReset: GameState()
    object Win: GameState()
    object Lose: GameState()

}
