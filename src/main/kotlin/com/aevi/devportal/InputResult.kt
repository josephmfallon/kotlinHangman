package com.aevi.devportal

sealed class InputResult {
    object ContinueToNextHandler : InputResult()
    object ReturnToLoop1 : InputResult()
    object InvalidInput : InputResult()
}