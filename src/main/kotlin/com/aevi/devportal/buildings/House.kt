package com.aevi.devportal.buildings

class House private constructor(number: Int, val occupants: Int = 1) : Building(number) {
    constructor(number: String, occupants: Int) : this(number.toInt())
}