package com.aevi.devportal.hangman.kaffy


import kotlin.random.Random


            fun main (args: Array<String>) {
                println("")
                var count = 1
                while (true) {
                    val hangmanWords = arrayOf("Rose", "Smile", "Apples", "Raisins", "Capricorn")
                    var word = hangmanWords[Random.nextInt(count)]
                    var wordToLetters = word.toUpperCase().toCharArray()
                    //toHashSet() to cover for duplicate letters
                    var plainLetters = wordToLetters.toHashSet()
                    val correctChoices = mutableSetOf<Char>()
                    println("Enter a letter to guess the word")

                    for (character in wordToLetters) {
                        print(Letters.BLANK.letters)
                    }
                    println("")
                    var ans = readLine()?.toUpperCase()

                    for (character in plainLetters) {
                        if (ans != null) {
                            if (ans == character.toString()) {
                                print(character + "")
                                //I GUESS USE correctChoices
                                for (character in wordToLetters) {
                                    print(Letters.BLANK.letters)
                                }
                                break
                            } else {
                                print(Letters.BLANK.letters)
                                print(ans)
                                println(" ")
                                print (character)
                            }
                        }
                    }


                    //mutable so each time a user gets a letter correct it can be added to the set of correct choices
                    //val correctChoices = mutableSetOf<Char>()
                    var fails = 0

                    // println(word.length)
                    //var hidden = arrayOf<Char>(Letters.BLANK, Letters.BLANK, Letters.BLANK, Letters.BLANK)
                    readLine()
                    count++

                }
            }








