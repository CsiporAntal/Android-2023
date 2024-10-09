package main

class ItemController(private val itemService: ItemService) {
    fun quiz(numberOfQuestions: Int) {
        val items = itemService.selectRandomItems(numberOfQuestions)
        var correctAnswers = 0

        for ((index, item) in items.withIndex()) {
            println("${index + 1}. ${item.question}")
            item.answers.forEachIndexed { i, answer ->
                println("${i + 1}. $answer")
            }

            var userAnswer: Int? = null
            while (userAnswer == null) {
                print("Your answer (1-4): ")
                val input = readLine()

                userAnswer = input?.toIntOrNull()
                if (userAnswer == null) {
                    println("This is not a valid number, please try again.\n")
                } else if (userAnswer !in 1..4) {
                    println("Please enter a number between 1 and 4.\n")
                    userAnswer = null // Reset to null to continue the loop
                }
            }

            if (userAnswer - 1 == item.correct) {
                println("Correct!\n")
                correctAnswers++
            } else {
                println("Wrong! Correct answer is: ${item.answers[item.correct]}\n")
            }
        }

        println("You got $correctAnswers out of $numberOfQuestions correct!")
    }
}

