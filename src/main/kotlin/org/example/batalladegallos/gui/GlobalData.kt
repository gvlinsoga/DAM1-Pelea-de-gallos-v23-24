package org.example.batalladegallos.gui

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.example.batalladegallos.Model.Participante

object GlobalData {
    val participants: ObservableList<Participante> = FXCollections.observableArrayList()
}