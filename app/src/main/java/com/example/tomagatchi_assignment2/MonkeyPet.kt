package com.example.tomagatchi_assignment2

class MonkeyPet {
    var health : Int = 100
    var hunger : Int = 100
    var joy : Int = 5
    var cleanliness : Int = 5

    fun feed(){
        hunger -= 10
        if (hunger<0) hunger = 0
    }
    fun play(){
        joy += 10
        if (joy>100) joy = 100
    }
    fun clean(){
        cleanliness += 10
        if (cleanliness>100) cleanliness = 100
    }
    fun decreaseHealth(){
        health -= 10
        if (health<0) health = 0
    }
    fun decreaseCleanliness(){
        cleanliness -= 10
        if (cleanliness<0) cleanliness = 0
    }
    fun decreaseJoy(){
        joy -= 10
        if (joy<0) joy = 0
    }
    fun increaseHunger(){
        hunger += 10
        if (hunger>100) hunger = 100
    }
    fun increaseHealth(){
        health += 10
        if (health > 100) health = 100
    }
    }
