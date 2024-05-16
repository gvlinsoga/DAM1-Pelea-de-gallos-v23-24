package org.example.BatallaDeGallos.GUI

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class Escenario : Application() {

    override fun start(primaryStage: Stage?) {
        val root: Parent = FXMLLoader.load(javaClass.getResource("/gui/arena.fxml"))
        primaryStage?.title = "Pelea de Gallos - Arena"
        primaryStage?.scene = Scene(root)
        primaryStage?.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Escenario::class.java)
        }
    }
}
