import main.Item
import java.io.File
import kotlin.system.exitProcess

object ItemRepository {
    private val items = mutableListOf<Item>()

    init {
        loadItemsFromFile("C:\\Users\\Toni\\IdeaProjects\\Android-2023\\kotlin-exercises\\labor-03\\src\\main\\questions.txt")

        /*
                items.addAll(
                    listOf(
                        Item("What is the keyword to declare a variable in Kotlin?", mutableListOf("val", "var", "const", "let"), 1),
                        Item("Which function is used to print in Kotlin?", mutableListOf("echo", "print", "println", "write"), 2),
                        Item("What is the default visibility modifier in Kotlin?", mutableListOf("public", "private", "internal", "protected"), 0),
                        Item("Which of the following is a nullable type in Kotlin?", mutableListOf("Int", "String", "Int?", "List"), 2),
                        Item("What is used for null safety in Kotlin?", mutableListOf("!", "?", "#", "&"), 1),
                        Item("How do you declare a function in Kotlin?", mutableListOf("def", "function", "fun", "lambda"), 2),
                        Item("Which of the following is an immutable collection in Kotlin?", mutableListOf("ArrayList", "MutableList", "List", "Set"), 2),
                        Item("What is the equivalent of 'switch' in Kotlin?", mutableListOf("when", "if", "else", "match"), 0),
                        Item("How do you create a singleton in Kotlin?", mutableListOf("object", "class", "singleton", "static"), 0),
                        Item("Which of the following is a coroutine builder in Kotlin?", mutableListOf("launch", "async", "await", "run"), 0)
                    )
                )


         */
    }

    private fun loadItemsFromFile(fileName: String) {
        try {
            val lines = File(fileName).readLines().filter { it.isNotBlank() }

            for (i in lines.indices step 6) {
                if (i + 5 < lines.size) {
                    val question = lines[i].trim()
                    val ans1 = lines[i + 1].trim()
                    val ans2 = lines[i + 2].trim()
                    val ans3 = lines[i + 3].trim()
                    val ans4 = lines[i + 4].trim()
                    val correctIndex = lines[i + 5].trim().toIntOrNull()

                    if (correctIndex != null && correctIndex in 0..3) {
                        val answers = mutableListOf(ans1, ans2, ans3, ans4)
                        save(Item(question, answers, correctIndex))
                    } else {
                        println("Invalid correct answer index for question: $question")
                    }
                } else {
                    println("Incomplete question data at line $i, skipping.")
                }
            }
        } catch (e: Exception) {
            println("Error reading questions from file: ${e.message}")
            e.printStackTrace()
            exitProcess(-1)
        }
    }


    fun randomItem(): Item = items.random()

    fun selectRandomItems(count: Int): List<Item> {
        return items.shuffled().take(count)
    }

    fun save(item: Item) {
        items.add(item)
    }

    fun size(): Int = items.size
}
