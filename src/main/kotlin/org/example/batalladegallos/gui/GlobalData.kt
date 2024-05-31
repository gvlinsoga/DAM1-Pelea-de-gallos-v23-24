package org.example.batalladegallos.gui

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.example.batalladegallos.Model.Participante

object GlobalData {
    var palabrasRimadasPlayer1: Map<String, List<String>> = mapOf()
    var palabrasRimadasPlayer2: Map<String, List<String>> = mapOf()
    val participants: ObservableList<Participante> = FXCollections.observableArrayList()
}