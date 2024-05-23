package org.example.BatallaDeGallos.Persistence.Ktor.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.BatallaDeGallos.Model.Participante

fun Route.databaseRouting() {
    route("/Participant") {
        get {

        }
        post {

        }
    }
}