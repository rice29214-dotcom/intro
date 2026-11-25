package com.niitlab.inventory

fun main() {

    // INPUT SECTION
    print("Enter number of products: ")
    val n = readln()?.toIntOrNull() ?: 0

    if (n <= 0) {
        println("Invalid number of products")
        return
    }


    val productNames = Array(n) { "" }
    val quantities = mutableListOf<Int>()
    val prices = mutableListOf<Double>()


    for (i in 0 until n) {

        println("\nProduct ${i + 1}")

        print("Enter product name: ")
        productNames[i] = readln()?.takeIf {
            it.isNotBlank()
        } ?: "Unknown"


        var quantity: Int

        do {
            print("Enter quantity (1 - 10000): ")
            quantity = readln()?.toIntOrNull() ?: 0

            if (quantity !in 1..10000) {
                println("Invalid quantity. Try again.")
            }

        } while (quantity !in 1..10000)

        quantities.add(quantity)

        //
        var price: Double

        do {
            print("Enter unit price (1 - 1000000): ")
            price = readln()?.toDoubleOrNull() ?: 0.0

            if (price !in 1.0..1000000.0) {
                println("Invalid price. Try again.")
            }

        } while (price !in 1.0..1000000.0)

        prices.add(price)
    }


    val stockValues = mutableListOf<Double>()
    var totalInventoryValue = 0.0

    for (i in 0 until n) {

        val value = quantities[i] * prices[i]

        stockValues.add(value)

        totalInventoryValue += value
    }

    var highestIndex = 0
    var lowestIndex = 0

    for (i in 1 until n) {

        if (stockValues[i] > stockValues[highestIndex]) {
            highestIndex = i
        }

        if (stockValues[i] < stockValues[lowestIndex]) {
            lowestIndex = i
        }
    }


    println("\n======= INVENTORY REPORT =========")

    println("Total Products: $n")

    println(
        "Highest Value Product: " +
                "${productNames[highestIndex]} = ${stockValues[highestIndex]}"
    )

    println(
        "Lowest Value Product: " +
                "${productNames[lowestIndex]} = ${stockValues[lowestIndex]}"
    )

    println("Total Inventory Value: $totalInventoryValue")

    println("====================================")
}