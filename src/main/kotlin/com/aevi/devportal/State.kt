package com.aevi.devportal

sealed class State {
    object PlayersTurn : State()
    object CharacterSelection : State()
}
