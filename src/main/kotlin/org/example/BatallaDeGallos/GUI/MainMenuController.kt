package org.example.BatallaDeGallos.GUI

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage
import javafx.stage.FileChooser
import java.io.File
import javafx.event.ActionEvent
import java.io.IOException

class MainMenuController {
    @FXML
    var loreBoton: Button = Button()

    @FXML
    var jugarBoton: Button = Button()

    @FXML
    var rankingBoton: Button = Button()

    @FXML
    var salirBoton: Button = Button()

    fun mainMenu() {
        try {

            loreBoton.setOnAction {
                explorarArchivos()
            }

            jugarBoton.setOnAction {
                //si el archivo está cargado, ir a la siguiente pantalla

            }

            rankingBoton.setOnAction {
                //ir al ranking
            }

            salirBoton.setOnAction {
                salir()
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }



 fun explorarArchivos(): ActionEvent? {
    val fileChooser = FileChooser()
    fileChooser.initialDirectory = File(System.getProperty("user.home"))

    val extFilter = FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt")
    fileChooser.extensionFilters.add(extFilter)

    val file = fileChooser.showOpenDialog(null)

    if (file != null) {
        println(file.absolutePath)
        loreBoton.text = "Lore: ${file.name}"
    }

    return null
}

    fun salir(){
        Platform.exit()
    }

}