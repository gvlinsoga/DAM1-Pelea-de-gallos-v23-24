package org.example.BatallaDeGallos.GUI

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class GameplayController : Application() {

    override fun start(primaryStage: Stage?) {
        val root: Parent = FXMLLoader.load(javaClass.getResource("/resources/gameplay.fxml"))
        primaryStage?.title = "Batalla de Gallos - Arena"
        primaryStage?.scene = Scene(root)
        primaryStage?.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(GameplayController::class.java)
        }
    }


}
