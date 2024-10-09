package main
import java.util.*

fun main(args: Array<String>) {
    //println("Hello World!")
    //exc1()
    //exc2()
    //exc3()
    //exc4()
    //exc5()
    //exc6()
    //exc7()
    exc8()

}
/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */


fun exc1() {
    val szam1 = 2
    val szam2 = 3

    val szam3 = szam1 + szam2
    println("result: $szam3")
    println("-----------------------------------------------------------")
}

fun exc2(){
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    for(day in daysOfWeek){

        println(day)
    }

    println("-----------------------------------------------------------")
    println("start with: T")

    daysOfWeek.filter { it.startsWith("T")}.forEach {
        println(it)
    }
    println("-----------------------------------------------------------")
    println("doesnt start with: T")


    daysOfWeek.filter { !it.startsWith("T")}.forEach {
        println(it)
    }
    println("-----------------------------------------------------------")
    println("contains: e")

    daysOfWeek.filter { it.contains("e") }.forEach {
        println(it)
    }

    println("-----------------------------------------------------------")
    println("lenght is 6 caracters")


    daysOfWeek.filter { it.length == 6 }.forEach {
        println(it)
    }

}

fun exc3(){
    for (i in 1..100){
        if(isPrime(i))
            println(i)
    }
    println("-----------------------------------------------------------")

}


fun exc4(){
    val message = "This is the message"
    //println(encodeString(message))
    //println(decodeString(encodeString(message)))

    val encodedMessage = messageCoding(message, ::encodeString)
    println(encodedMessage)
    val decodedMessage = messageCoding(encodedMessage, ::decodeString)
    println(decodedMessage)

}



fun exc5(){
    val number = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    printEvenNumberFromList(number)

}


fun exc6(){
    val listInt = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    for(number in listInt) println(number)
    println("----------------------------------------")
    val doubleListInt = listInt.map { it.times(2) }
    for(number in doubleListInt) println(number)
    println("----------------------------------------")



}

fun exc7() {
    // Convert the daysOfWeek immutable list into a mutable one
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val mutableDaysOfWeek = daysOfWeek.toMutableList()

    // Remove all days containing the letter 'n'
    mutableDaysOfWeek.removeAll { it.contains('n') }
    println(mutableDaysOfWeek) // [Tuesday, Thursday, Friday, Saturday]

    // Print each element with index using withIndex()
    mutableDaysOfWeek.withIndex().forEach { (index, day) ->
        println("Item at $index is $day")
    }

    // Sort the list alphabetically and print the result
    mutableDaysOfWeek.sort()
    println(mutableDaysOfWeek) // [Friday, Saturday, Thursday, Tuesday]
}

fun exc8() {
    // Generate an array of 10 random integers between 0 and 100
    val randomNumbers = IntArray(10) { (0..100).random() }

    // Print each element of the array
    println("Random numbers:")
    randomNumbers.forEach { println(it) }

    // Sort and print the array in ascending order
    val sortedNumbers = randomNumbers.sorted()
    println("\nSorted numbers:")
    println(sortedNumbers)

    // Check whether the array contains any even number
    val containsEven = randomNumbers.any { it % 2 == 0 }
    println("\nContains any even number: $containsEven")

    // Check whether all the numbers are even
    val allEven = randomNumbers.all { it % 2 == 0 }
    println("All numbers are even: $allEven")

    // Calculate and print the average of the numbers
    val average = randomNumbers.average()
    println("Average of numbers: $average")
}









fun encodeString(message: String): String{
    return Base64.getEncoder().encodeToString(message.toByteArray())
}



fun decodeString(encodedMessage: String): String{
    return String(Base64.getDecoder().decode(encodedMessage))
}

fun messageCoding(msg: String, func: (String) -> String): String{
    return func(msg)
}


// exemple Compact function
fun double(x: Int):Int = x * 2


fun printEvenNumberFromList(numbers: IntArray) = numbers.filter{ it % 2 == 0 }.forEach { println(it) }


// Helping functions:
fun isPrime(n: Int): Boolean {
    if (n <= 1) return false // 0 and 1 are not prime numbers
    if (n == 2 || n == 3) return true // 2 and 3 are prime numbers
    if (n % 2 == 0 || n % 3 == 0) return false // Exclude multiples of 2 and 3

    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
    }

    return true
}



