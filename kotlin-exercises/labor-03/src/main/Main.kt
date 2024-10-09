package main

import ItemRepository

fun main() {
    val repository = ItemRepository

    val testQuizItem = repository.randomItem()
    print("Question = $testQuizItem\n")
    println("---------------------------------------------------------------------------------")

    val service = ItemService(repository)

    // Test
    val quizItems = service.selectRandomItems(3)
    for (quizItem in quizItems){
        println("Question = " + quizItem)
    }
    println("---------------------------------------------------------------------------------")
    print("Enter the number of questions you want to attempt: ")
    val numberOfQuestions = readLine()?.toIntOrNull() ?: 5

    val controller = ItemController(service)
    controller.quiz(numberOfQuestions)
}
