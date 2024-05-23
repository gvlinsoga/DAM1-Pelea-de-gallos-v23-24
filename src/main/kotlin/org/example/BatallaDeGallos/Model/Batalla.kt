package org.example.BatallaDeGallos.Model

    data class Batalla(
        val id: Int,
        val fecha: String,
        val participante1Id: Int,
        val participante2Id: Int,
        val palabrasUtilizadas: MutableList<String>,
        val ganadorId: Int
    )
