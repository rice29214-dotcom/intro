package com.niitlab.intro

abstract class Vehicle {

    abstract fun startEngine()

     fun fuelUp(){
        println("fueling up vehicle")
    }

    fun stopEngine(){
        println("stopping vehicle")
    }
}