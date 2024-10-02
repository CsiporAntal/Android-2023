package main

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


    val name = "John Smith"
    println(name.nameMonogram())

    val list = listOf("apple", "pear", "melon")
    println(list.joinElemnts("#"))

    val Longest = listOf("apple", "pear", "strawberry", "melon")
    println(Longest.getLongestElement())


    // PROBLEM 3

    // TODO ......
}


fun String.nameMonogram(): String{
    return this.split(" ").map { it[0] }.joinToString("")
}

fun List<String>.joinElemnts(separator: String): String = this.joinToString(separator)

fun List<String>.getLongestElement(): String = this.maxByOrNull { it.length }.toString()