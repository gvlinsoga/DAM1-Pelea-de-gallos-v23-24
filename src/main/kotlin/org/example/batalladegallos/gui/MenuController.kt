package org.example.batalladegallos.gui

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.FileChooser
import java.io.File
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.ButtonType
import javafx.scene.control.DialogPane
import javafx.scene.control.MenuButton
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.awt.MenuItem
import java.io.IOException

class MenuController {
    @FXML
    var loreBoton: Button = Button()

    @FXML
    lateinit var jugarBoton: Button
    @FXML
    lateinit var registrarPersonajes: Button

    @FXML
    var rankingBoton: Button = Button()

    @FXML
    var salirBoton: Button = Button()

    @FXML
    private lateinit var userAvatar: ImageView

    @FXML
    private lateinit var avatarsMenu: MenuButton

    @FXML
    private lateinit var angryCatItem: javafx.scene.control.MenuItem

    @FXML
    private lateinit var catspurrovItem: javafx.scene.control.MenuItem

    @FXML
    private lateinit var mittensItem: javafx.scene.control.MenuItem

    @FXML
    private lateinit var mrGrumpItem: javafx.scene.control.MenuItem

    @FXML
    private lateinit var scaredyCatItem: javafx.scene.control.MenuItem

    @FXML
    fun initialize() {
        angryCatItem.setOnAction { changeAvatar("angry_cat.png") }
        catspurrovItem.setOnAction { changeAvatar("Catspurrov.png") }
        mittensItem.setOnAction { changeAvatar("mittens.png") }
        mrGrumpItem.setOnAction { changeAvatar("mr_grump.png") }
        scaredyCatItem.setOnAction { changeAvatar("scaredy_cat.png") }
    }

    private fun changeAvatar(imagePath: String) {
        val avatar = Image(javaClass.getResourceAsStream("/images/$imagePath"))
        userAvatar.image = avatar
    }

    fun mainMenu() {
        try {

            loreBoton.setOnAction {
                explorarArchivos()
            }
            registrarPersonajes.setOnAction {
                openNewCharacterDialog()
                initialize()
            }

            jugarBoton.setOnAction {
                siguientePantalla()

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


    fun explorarArchivos() {
        val fileChooser = FileChooser()
        fileChooser.initialDirectory = File(System.getProperty("user.home"))

        val extFilter = FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt")
        fileChooser.extensionFilters.add(extFilter)

        val file = fileChooser.showOpenDialog(null)

        if (file != null) {
            println(file.absolutePath)
            loreBoton.text = "Lore: ${file.name}"

        }
    }

    fun salir() {
        Platform.exit()
    }

    @Throws(IOException::class)
    fun siguientePantalla() {
        val currentStage = jugarBoton.scene.window as Stage

        val fxmlLoader = FXMLLoader(javaClass.getResource("character-screen.fxml"))
        val scene = Scene(fxmlLoader.load())
        currentStage.title = "Batalla de Gallos - Siguiente Pantalla"
        currentStage.scene = scene
        currentStage.show()
    }

    @Throws(IOException::class)
    fun openNewCharacterDialog() {
        val dialog = javafx.scene.control.Dialog<ButtonType>()
        dialog.title = "Nuevo Personaje"

        val fxmlLoader = FXMLLoader(javaClass.getResource("newcharacter-popup.fxml"))
        val dialogPane = fxmlLoader.load<DialogPane>()

        dialog.dialogPane = dialogPane
        dialog.dialogPane.buttonTypes.addAll(ButtonType.OK, ButtonType.CANCEL)

        val result = dialog.showAndWait()
        result.ifPresent { buttonType ->
            if (buttonType == ButtonType.OK) {
                println("OK button clicked")
                // Handle saving the new character
            }
        }
    }

}