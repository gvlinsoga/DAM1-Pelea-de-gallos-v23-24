package org.example.BatallaDeGallos.GUI

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.io.IOException

class Main : Application() {
    @Throws(IOException::class)
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(Main::class.java.getResource("main-menu.fxml"))
        println("aaaaaaaadfsdhguidhfhhxndf")
        val scene = Scene(fxmlLoader.load())
        stage.title = "Batalla de Gallos - Menú Principal"
        stage.scene = scene
        stage.show()

        val controller = fxmlLoader.getController<MainMenuController>()
        controller.mainMenu()
    }

}

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}