package intro

class Car(var name: String) {


    var brand = " "
    var speed = 0.0

    fun drive() {
        println("$name driving $brand at $speed km/h")
    }
}

class Calc(var a: Int, var b: Int) {

    constructor(a:Int) : this(a,10)

    constructor():this(30,20)

    fun add() = a * b
}

class Animal(
    var breed: String,
    var sound : String,
    var movement: String,
    var origin :String,
    var food :String,
){
    fun showAnimal(){
        println(" is found in $origin")
        println("")
    }
}