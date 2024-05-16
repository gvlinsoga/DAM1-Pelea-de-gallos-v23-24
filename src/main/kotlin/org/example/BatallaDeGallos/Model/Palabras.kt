package org.example.BatallaDeGallos.Model

import java.io.File

class Palabras(private val rutaArchivo: String) {

    fun obtenerPalabrasUnicas(): List<String> {
        val palabrasUnicas = HashSet<String>()
        File(rutaArchivo).forEachLine { linea ->
            val palabras = linea.split("\\s+".toRegex())
            palabrasUnicas.addAll(palabras)
        }
        return palabrasUnicas.toList()
    }
}
