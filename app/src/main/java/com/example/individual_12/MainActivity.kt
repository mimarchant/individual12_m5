package com.example.individual_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {

    var nombre: String
    var apellido: String
    var edad: Int
    var correo: String
    var sistemaSalud: String

    val usuarios = mutableListOf<Usuario>()
    println("Ingrese la cantidad de usuarios: ")
    var cantidadUsuario = readLine()!!.toInt()

    for (i in 1..cantidadUsuario) {

        println("Ingrese nombre: ")
        nombre = readln()
        while (!validarNombre(nombre)) {
            println("Nombre inválido, ingrese un nombre válido.")
            nombre = readln()
        }

        println("Ingrese apellido: ")
        apellido = readln()
        while (!validarApellido(apellido)) {
            println("Apellido inválido, ingrese un apellido válido.")
            apellido = readln()
        }


        println("Ingrese edad: ")
        edad = readln().toInt()
        while (!validarEdad(edad)) {
            println("Edad inválido, ingrese una edad válida.")
            edad = readln().toInt()
        }


        println("Ingrese correo electrónico: ")
        correo = readln()
        while (!validarCorreo(correo)) {
            println("Correo inválido, ingrese un correo válido.")
            correo = readln()
        }


        println("Ingrese su sistema de salud (escriba una de las opciones):")
        println("1.Fonasa")
        println("2.Isapre")
        println("3.Particular")
        sistemaSalud = readln()
        while (!validarSistema(sistemaSalud)) {
            println("Sistema de salud inválido, ingrese un sistema de salud válido.")
            sistemaSalud = readln()
        }


        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)

        for (u in usuarios.sortedBy { it.edad }) {
            println(u)
        }
    }
}


fun validarSistema(sistemaSalud: String): Boolean {
    if (sistemaSalud.uppercase().lowercase() == "Fonasa" || sistemaSalud.uppercase()
            .lowercase() == "Isapre" || sistemaSalud.uppercase().lowercase() == "Particular"
    ) {
        return false

    }
    return true
}


fun validarEdad(edad: Int): Boolean {
    return edad in 1..115
}


fun validarCorreo(correo: String): Boolean {
    return correo.length in 10..200 && correo.contains(Regex("@"))
    //Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
}


fun validarApellido(apellido: String): Boolean {
    return apellido.length in 1..20 && apellido.all { it.isLetterOrDigit() }

}

fun validarNombre(nombre: String): Boolean {
    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }

}