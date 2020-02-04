package com.aevi.devportal

sealed class State {
    object CharacterSelection : State()
    object GameRound : State()
    object GameOver : State()
}
