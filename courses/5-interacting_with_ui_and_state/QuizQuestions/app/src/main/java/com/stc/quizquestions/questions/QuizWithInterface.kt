package com.stc.quizquestions.questions

import com.stc.quizquestions.questions.generic.Difficulty
import com.stc.quizquestions.questions.generic.Question
import com.stc.quizquestions.questions.interfacePackage.ProgressPrintable

class QuizWithInterface: ProgressPrintable {

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)

    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }


}
fun main() {
    QuizWithInterface().printProgressBar()

    val quizWithInterface = QuizWithInterface()
    quizWithInterface.printQuiz()

}
