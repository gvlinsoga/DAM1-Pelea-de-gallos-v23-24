package org.example.batalladegallos.Persistence

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.example.batalladegallos.Model.Batalla
import org.example.batalladegallos.Model.Palabras
import org.example.batalladegallos.Model.Participante

class Mongo {
    var mongoClient: MongoClient? = null  // Client de MongoDB
    var database: MongoDatabase? = null    // Base de dades MongoDB

    // Mètode per establir una connexió amb la base de dades MongoDB
    fun connexioBD() {
        // URL de connexió a MongoDB
        val mongoUrl = "mongodb+srv://alejandromorcillo7e7:BaseMongo@clustergallos.cahzq69.mongodb.net/?retryWrites=true&w=majority&appName=ClusterGallos"
        // Crea un client de MongoDB utilitzant la URL proporcionada
        mongoClient = MongoClients.create(mongoUrl)
        // Obre la base de dades especificada
        database = mongoClient!!.getDatabase("Data")
    }

    // Mètode per inserir un document a una col·lecció de la base de dades MongoDB
    fun insereix(colleccio: String, objecte: Any) {
        // Obté la col·lecció de la base de dades
        val colLeccio: MongoCollection<Document> = database!!.getCollection(colleccio)
        // Crea un document MongoDB segons el tipus d'objecte passat com a paràmetre
        val document = when(objecte) {
            is Batalla -> Document(
                mapOf(
                    "id" to objecte.id,
                    "fecha" to objecte.fecha,
                    "participante1Id" to objecte.participante1Id,
                    "participante2Id" to objecte.participante2Id,
                    "palabrasUtilizadas" to objecte.palabrasUtilizadas,
                    "ganadorId" to objecte.ganadorId
                )
            )
            is Participante -> Document(
                mapOf(

                    "nombre" to objecte.nombre,
                    "urlFotoPerfil" to objecte.urlFotoPerfil,
                    "puntuacion" to objecte.puntuacion,
                )
            )
            is Palabras -> Document(
                mapOf(
                    "palabrasDisponibles" to objecte.palabrasDisponibles,
                )
            )
            else -> throw Exception("Object not found") // Llança una excepció si l'objecte no es troba
        }
        println(document) // Mostra el document abans de ser inserit per a propòsits de depuració
        // Insereix el document a la col·lecció
        colLeccio.insertOne(document)
    }

    fun retrieve(colleccio: String, filter: Document, clazz: String): List<Any> {
        // Obté la col·lecció de la base de dades
        val colLeccio: MongoCollection<Document> = database!!.getCollection(colleccio)
        // Cerca els documents segons el filtre proporcionat
        val documents = colLeccio.find(filter).toList()
        // Converteix els documents en objectes Kotlin
        val objects = documents.map { document ->
            when (clazz) {
                "Batalla" -> Batalla(
                    id = document.getInteger("id"),
                    fecha = document.getString("fecha"),
                    participante1Id = document.getInteger("participante1Id"),
                    participante2Id = document.getInteger("participante2Id"),
                    palabrasUtilizadas = document.getList("palabrasUtilizadas", String::class.java),
                    ganadorId = document.getInteger("ganadorId")
                )
                "Participantes" -> Participante(

                    nombre = document.getString("nombre"),
                    urlFotoPerfil = document.getString("urlFotoPerfil"),
                    puntuacion = document.getInteger("id")
                )
                "Palabras" ->Palabras("REVISAR",
                    palabrasDisponibles = document.getList("palabrasDisponibles", String::class.java)
                )
                else -> throw Exception("Unsupported class")
            }
        }
        return objects
    }

    // Mètode per tancar la connexió amb la base de dades MongoDB
    fun desconnexioBD() {
        // Verifica si hi ha una connexió vàlida abans de tancar-la
        if (mongoClient != null) {
            mongoClient!!.close()
        } else {
            // Llança una excepció si no hi ha cap connexió disponible per tancar
            throw Exception("There is no connection")
        }
    }
}
