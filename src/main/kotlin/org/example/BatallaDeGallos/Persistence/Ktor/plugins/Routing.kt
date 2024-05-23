package org.example.BatallaDeGallos.Persistence.Ktor.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.example.BatallaDeGallos.Persistence.Ktor.routes.databaseRouting

fun Application.configureRouting() {
    routing {
        databaseRouting()
    }
}
