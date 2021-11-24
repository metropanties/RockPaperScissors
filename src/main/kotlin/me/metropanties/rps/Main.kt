package me.metropanties.rps

import java.util.*
import kotlin.random.Random

const val logo = """    ____  ____  _____    _________    __  _________
   / __ \/ __ \/ ___/   / ____/   |  /  |/  / ____/
  / /_/ / /_/ /\__ \   / / __/ /| | / /|_/ / __/   
 / _, _/ ____/___/ /  / /_/ / ___ |/ /  / / /___   
/_/ |_/_/    /____/   \____/_/  |_/_/  /_/_____/   """
val inputs = listOf("Rock", "Paper", "Scissors")

fun main() {
    init()
}

fun init() {
    var playerScore = 0
    var botScore = 0;

    println(logo + "\n")
    var i = 0;
    val scanner = Scanner(System.`in`)
    do {
        println("Select: Rock, Paper, Scissors.")
        val input = scanner.next()
        val botInput = getRandom(inputs)

        if (!validateInput(input)) {
            println("Game Ended: You have selected an invalid option.")
            break
        }

        if (input.equals(botInput, ignoreCase = true)) {
            continue
        } else if (input.equals("rock", ignoreCase = true)) {
            if (botInput.equals("paper", ignoreCase = true)) {
                botScore++
            } else if (botInput.equals("scissors", ignoreCase = true)) {
                playerScore++
            }
        } else if (input.equals("paper", ignoreCase = true)) {
            if (botInput.equals("rock", ignoreCase = true)) {
                playerScore++
            } else if (botInput.equals("scissors", ignoreCase = true)) {
                botScore++
            }
        } else if (input.equals("scissors", ignoreCase = true)) {
            if (botInput.equals("rock", ignoreCase = true)) {
                botScore++
            } else if (botInput.equals("paper", ignoreCase = true)) {
                playerScore++
            }
        }

        println("Score: $playerScore (You) : $botScore (AI)")
        i++
        if (i == 3) {
            if (playerScore > botScore) {
                println("You have won the game!")
            } else {
                println("You have lost the game!")
            }
        }
    } while (i != 3 || !validateInput(input))
}

fun validateInput(input: String): Boolean {
    for (options in inputs) {
        if (input.equals(options, ignoreCase = true))
            return true
    }
    return false
}

fun getRandom(list: List<String>): String {
    return list[Random.nextInt(list.size)]
}

