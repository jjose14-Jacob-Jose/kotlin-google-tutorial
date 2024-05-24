package com.stc.quizquestions.questions

import com.stc.quizquestions.questions.generic.Difficulty
import com.stc.quizquestions.questions.generic.Question

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

//Extending 'Quiz/StudentProgress' by adding a new variable 'progressText'
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered."

//Extending 'Quiz/StudentProgress' by adding a method 'printProgressBar'
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)

}

fun main() {
    println("---------------------------------------------------- START ----------------------------------------------------")

    println("Accessing using 'companion': ")
    println("${Quiz.answered} of ${Quiz.total} answered.")
    println("----------------------------------------------------")

    println("Extension: ")
    println("\t" + "variable: ")
    println(Quiz.progressText)

    println("\t" + "function: ")
    Quiz.printProgressBar()

    println("---------------------------------------------------- END ----------------------------------------------------")


}
