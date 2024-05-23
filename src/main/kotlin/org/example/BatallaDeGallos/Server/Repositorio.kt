
package org.example.BatallaDeGallos.Server
/*
import BaseDeDatosHandler
import java.text.SimpleDateFormat
import java.util.*
import java.io.File
import java.io.IOException
import org.example.BatallaDeGallos.Model.Batalla
import org.example.BatallaDeGallos.Model.Participante
import org.example.BatallaDeGallos.Model.Palabra



class Repositorio(private val baseDeDatosHandler: BaseDeDatosHandler) {

    fun cargarPalabrasDesdeArchivo(rutaArchivo: String) {
        val palabrasUnicas = leerPalabrasUnicas(rutaArchivo)
        palabrasUnicas.forEach { palabra ->
            baseDeDatosHandler.insertarPalabra(palabra)
        }
    }

    private fun leerPalabrasUnicas(rutaArchivo: String): Set<String> {
        val palabrasUnicas = mutableSetOf<String>()
        try {
            val file = File(rutaArchivo)
            file.forEachLine { line ->
                val palabras = line.split("\\s+".toRegex()).filter { it.isNotBlank() }
                palabrasUnicas.addAll(palabras)
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return palabrasUnicas
    }

    fun crearParticipante(nombre: String, urlFotoPerfil: String) {
        baseDeDatosHandler.insertarParticipante(nombre, urlFotoPerfil)
    }

    fun crearBatalla(participante1Id: Int, participante2Id: Int): Batalla? {
        val participantes = obtenerParticipantes()
        val participante1 = participantes.find { it.id == participante1Id }
        val participante2 = participantes.find { it.id == participante2Id }

        if (participante1 != null && participante2 != null) {
            val palabrasUtilizadas = obtenerPalabrasAleatorias()
            val ganadorId = obtenerGanadorId(participante1Id, participante2Id)

            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val fecha = dateFormat.format(Date())

            baseDeDatosHandler.insertarBatalla(fecha, participante1Id, participante2Id, palabrasUtilizadas, ganadorId)
            return Batalla(-1, fecha, participante1Id, participante2Id, palabrasUtilizadas, ganadorId)
        }
        return null
    }

    fun obtenerParticipantes(): List<Participante> {
        return baseDeDatosHandler.obtenerParticipantes()
    }


    private fun obtenerPalabrasAleatorias(cantidad: Int): List<Palabra> {
        return baseDeDatosHandler.obtenerPalabrasAleatorias(cantidad)
    }

    private fun obtenerGanadorId(participante1Id: Int, participante2Id: Int): Int {
        // Simplemente retorna uno de los dos participantes al azar como ganador
        return if (Random().nextBoolean()) participante1Id else participante2Id
    }
}
*/
