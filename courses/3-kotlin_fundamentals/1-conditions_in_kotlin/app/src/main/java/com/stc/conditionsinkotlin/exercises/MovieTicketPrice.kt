package com.stc.conditionsinkotlin.exercises

class MovieTicketPrice {
}
fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    when {
        age <= 12 -> return 15
        age in 13..60 -> {
            if (isMonday)
                return 25
            else
                return 30
        }
        age in 61..100 -> return 20
        else -> return -1
    }
}