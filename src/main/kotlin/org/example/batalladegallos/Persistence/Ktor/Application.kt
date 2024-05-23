package org.example.batalladegallos.Persistence.Ktor

import io.ktor.server.application.*
import org.example.batalladegallos.Persistence.Ktor.plugins.configureRouting
import org.example.batalladegallos.Persistence.Ktor.plugins.configureSerialization

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
