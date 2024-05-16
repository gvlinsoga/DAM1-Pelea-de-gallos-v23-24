package org.example.BatallaDeGallos.Server

import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val repositorio = Repositorio()
    embeddedServer(Netty, port = 8080) {
        iniciarServidor(repositorio)
    }.start(wait = true)
}
