package org.example.BatallaDeGallos.Server
/*

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json




fun Application.iniciarServidor(repositorio: Repositorio) {
    routing {
        get("/palabras") {
            val palabras = repositorio.obtenerPalabras()
            call.respond(Json.encodeToString(palabras))
        }

        get("/participantes") {
            val participantes = repositorio.obtenerParticipantes()
            call.respond(Json.encodeToString(participantes))
        }

        post("/participantes") {
            val nuevoParticipante = call.receive<Participante>()
            val id = repositorio.insertarParticipante(nuevoParticipante)
            call.respond(id)
        }

        post("/batallas") {
            val nuevaBatalla = call.receive<Batalla>()
            val id = repositorio.insertarBatalla(nuevaBatalla.fecha, nuevaBatalla.participante1Id, nuevaBatalla.participante2Id, nuevaBatalla.palabras, nuevaBatalla.ganadorId)
            call.respond(id)
        }

        post("/palabras") {
            val nuevaPalabra = call.receive<Palabra>()
            val id = repositorio.insertarPalabra(nuevaPalabra)
            call.respond(id)
        }
    }
}
*/
