package org.example.BatallaDeGallos.Persistence.Ktor

import io.ktor.server.application.*
import org.example.BatallaDeGallos.Persistence.Ktor.plugins.configureRouting
import org.example.BatallaDeGallos.Persistence.Ktor.plugins.configureSerialization

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
