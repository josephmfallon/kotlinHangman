package com.aevi.devportal.nac.input

sealed class InputResult {
    object ContinueToNextHandler : InputResult()
    object ReturnToLoop1 : InputResult()
    object InvalidInput : InputResult()
    object StopRunning : InputResult()
}