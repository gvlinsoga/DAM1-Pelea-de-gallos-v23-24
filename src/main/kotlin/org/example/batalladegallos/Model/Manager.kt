package org.example.batalladegallos.Model
import java.io.File

class Manager {
    private val filePath: String = "/Users/adrian.galinsoga/Desktop/DAM1-Pelea-de-gallos-v23-24/src/main/kotlin/org/example/BatallaDeGallos/Persistence/TirantLoBlanc_Caps1_99.txt"
    private val palabrasDisponibles: MutableSet<String> = HashSet()

    init {
        cargarPalabras()
    }

    private fun cargarPalabras() {
        val file = File(filePath)
        file.forEachLine { line ->
            val palabras = line.trim().split("\\s+".toRegex())
            palabrasDisponibles.addAll(palabras)
        }
    }

    fun obtenerPalabrasUnicas(cantidad: Int): List<String> {
        return palabrasDisponibles.shuffled().distinct().take(cantidad)
    }
}
