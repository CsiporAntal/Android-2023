package main

import java.io.File
import java.util.*

object TreeSetDictionary : IDictionary {
    private val words = TreeSet<String>()

    init{
        File(IDictionary.DICTIONARY_NAME).forEachLine{ add(it) }
        println("File reading finished!")
    }
    override fun add(word: String): Boolean {
        return words.add(word)
    }

    override fun find(word: String): Boolean {
        return words.find { it == word } != null
    }

    override fun size(): Int {
        return words.size
    }


}