package main

import java.time.LocalDate

data class MyDate(val year: Int, val month: Int, val day: Int): Comparable<MyDate> {
    // Implement the Comparable interface for natural ordering
    override fun compareTo(other: MyDate): Int {
        return compareValuesBy(this, other, MyDate::year, MyDate::month, MyDate::day)
    }
}

fun MyDate.isLeapYear(): Boolean{
    return (this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0)

}

fun MyDate.isValid(): Boolean {
    return try {
        LocalDate.of(year, month, day)
        true
    } catch (e: Exception) {
        false
    }
}