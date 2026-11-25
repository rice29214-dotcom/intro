package com.niitlab.collections

fun main(){
    // create an empty list
    val numbers = mutableListOf<Int>()

    // Get 5 numbers from the user
    repeat(5){
        print("Enter a number: ")
        val number = readln()!!.toInt()

        numbers.add(number)
    }


    println("Numbers in the list: $numbers")

    // Calculate the sum
    val sum = numbers.sum()

    println("Sum of the numbers: $sum")

    // Calculate the average
    val average = numbers.average()

    println("Average of the numbers: $average")

}