package org.example.BatallaDeGallos.GUI

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage
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
                val stage = loreBoton.getScene().getWindow() as Stage
                val fxmlLoader = FXMLLoader(Main::class.java.getResource("main-menu.fxml"))
                val scene = Scene(fxmlLoader.load())
                stage.scene = scene

                loreBoton.setOnAction {
                    //Explorador de archivos para .txt y reflejar el título en el boton
                }

                jugarBoton.setOnAction{
                    //si el archivo está cargado, ir a la siguiente pantalla

                }

                rankingBoton.setOnAction{
                    //ir al ranking
                }

                salirBoton.setOnAction{
                    Platform.exit()
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


}