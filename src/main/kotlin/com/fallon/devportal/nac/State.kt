package com.fallon.devportal.nac

sealed class State {
    object CharacterSelection : State()
    object GameRound : State()
    object GameOver : State()
    object GameReset : State()
    object Win : State()
    object Lose : State()
}
