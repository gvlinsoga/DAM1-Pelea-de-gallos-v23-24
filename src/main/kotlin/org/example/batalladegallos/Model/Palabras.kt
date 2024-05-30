package org.example.batalladegallos.Model

data class Palabras(val rima: String, val palabrasDisponibles: MutableList<String>) {
    val palabrasUsadas = mutableListOf<String>()
}
