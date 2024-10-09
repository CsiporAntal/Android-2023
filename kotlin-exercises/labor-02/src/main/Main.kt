package main

import kotlin.random.Random

fun main() {

    // PROBLEM 1
/*
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while (true) {
        print("What to find? ")
        word = readLine()
        if (word.equals("quit")) {
            break
        }
        val startTime = System.nanoTime()  // Start timing before the find operation
        val result = word?.let { dict.find(it) }
        val endTime = System.nanoTime()    // End timing after the find operation
        val duration = endTime - startTime // Calculate the time taken in nanoseconds
        println("Result: $result")
        println("Time taken: ${duration / 1_000_000} ms") // Convert nanoseconds to milliseconds
    }
*/


    // PROBLEM 2

/*

    val name = "John Smith"
    println(name.nameMonogram())

    val list = listOf("apple", "pear", "melon")
    println(list.joinElemnts("#"))

    val Longest = listOf("apple", "pear", "strawberry", "melon")
    println(Longest.getLongestElement())
*/


    // PROBLEM 3



    val validDates = mutableListOf<MyDate>()
    val invalidDates = mutableListOf<MyDate>()

    // Generate random dates until we have 10 valid ones
    while (validDates.size < 10) {
        val randomYear = Random.nextInt(-2100, 2100)
        val randomMonth = Random.nextInt(-32, 13)
        val randomDay = Random.nextInt(-32, 32)
        val randomDate = MyDate(randomYear, randomMonth, randomDay)

        if (randomDate.isValid()) {
            validDates.add(randomDate)
        } else {
            invalidDates.add(randomDate)
        }
    }

    // Print invalid dates
    println("Invalid Dates:")
    invalidDates.forEach { println(it) }

    // Print the list of valid dates
    println("\nValid Dates:")
    validDates.forEach { println(it) }

    // Sort the valid dates list using the natural ordering
    validDates.sort()
    println("\nSorted Valid Dates:")
    validDates.forEach { println(it) }

    // Reverse the sorted list and print
    validDates.reverse()
    println("\nReversed Sorted Valid Dates:")
    validDates.forEach { println(it) }

    // Sort using a custom comparator (by month first, then by day, then by year)
    val customComparator = Comparator<MyDate> { date1, date2 ->
        compareValuesBy(date1, date2, MyDate::month, MyDate::day, MyDate::year)
    }

    validDates.sortWith(customComparator)
    println("\nCustom Sorted Valid Dates (by month, day, then year):")
    validDates.forEach { println(it) }

}


fun String.nameMonogram(): String{
    return this.split(" ").map { it[0] }.joinToString("")
}

fun List<String>.joinElemnts(separator: String): String = this.joinToString(separator)

fun List<String>.getLongestElement(): String = this.maxByOrNull { it.length }.toString()