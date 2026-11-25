package com.niitlab.collections

fun List(){

    var fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    val mutableFruits = mutableListOf("apple","banana", "avocado")

    println(mutableFruits)

    for(fruit in fruits){
        println(fruit)
    }
}