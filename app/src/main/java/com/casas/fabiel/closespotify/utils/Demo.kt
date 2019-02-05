package com.casas.fabiel.closespotify.utils

import android.util.Log

class Demo {
    val a = 20
    val b = 3
    val c: Long = 12
    val d: Int = 12
    val texto: String = "12"
    var sum1 = 0
    val persona = Persona("Ana", 14)
    var persona2 = Persona("Pepe", 24)

    init {
        val suma = sum()
        count(suma)
        val result = whenCaseValue(suma)
        Log.d("*******", result)
    }

    fun sum(): Int {
        sum1 = a + b
        persona2 = persona
        persona2.name = "Maria"
        return sum1
    }

    fun count(number: Int) {
        for (i in number downTo 0 step 3) {
            Log.d("*******", "Count: $i")
        }
    }

    fun whenCaseValue(suma: Int): String {
        return when(suma) {
            in 0..7 -> {
                Log.d("******", "Hola que hace")
                "Long"
            }
            8 -> {
                Log.d("******", "vale 8")
                "8"
            }
            else -> {
                Log.d("*******", "no paso nada")
                "Nada"
            }
        }
    }

}

class Persona(var name: String, var age: Int)