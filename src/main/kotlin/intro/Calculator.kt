package com.niitlab.intro


fun main() {

class Calculator(
    var num1: Double,
    var num2: Double,
    var `operator`: String
) {

    init {
        require(num1 > 0) {
            "First number must be greater than zero"
        }

        require(num2 > 0) {
            "Second number must be greater than zero"
        }
    }


    fun addition(): Double {
        return num1 + num2
    }


    fun subtraction(): Double {
        return num1 - num2
    }


    fun multiplication(): Double {
        return num1 * num2
    }


    fun division(): Double {
        require(num2 != 0.0) {
            "Cannot divide by zero"
        }
        return num1 / num2
    }


    fun calculate(): Double {
        return when (`operator`) {
            "+" -> addition()
            "-" -> subtraction()
            "*" -> multiplication()
            "/" -> division()
            else -> throw IllegalArgumentException(
                "Unknown operator"
            )
        }
    }
}
    println("===== SIMPLE CALCULATOR =====")

    print("Enter first number: ")
    val num1 = readln()!!.toDouble()

    print("Enter second number: ")
    val num2 = readln()!!.toDouble()

    println("Choose an operator (+, -, *, /)")
    print("Enter operator: ")
    val operator = readln()!!

    try {
        val calculator = Calculator(num1, num2, operator)

        println("Result: ${calculator.calculate()}")

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}