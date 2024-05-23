package org.example.batalladegallos.Persistence.Ktor.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.example.batalladegallos.Persistence.Ktor.routes.databaseRouting

fun Application.configureRouting() {
    routing {
        databaseRouting()
    }
}
