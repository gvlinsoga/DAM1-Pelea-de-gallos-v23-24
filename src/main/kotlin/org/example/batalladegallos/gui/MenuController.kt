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
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import javafx.scene.control.MenuItem
import java.io.IOException

class MenuController {
    @FXML
    var loreBoton: Button = Button()

    @FXML
    lateinit var jugarBoton: Button

    @FXML
    lateinit var nuevoGalloBoton: Button

    @FXML
    var rankingBoton: Button = Button()

    @FXML
    var salirBoton: Button = Button()

    @FXML
    var userAvatar: ImageView = ImageView()
    private lateinit var nombreAvatar: Label
    private val imageNames = listOf("mrGrump.png", "mittens.png", "angryCat.png", "scaredy.png", "catspurrov.png")
    private val labels = listOf("Mr Grump", "Mittens", "Angry Cat", "Scaredy", "Catspurrov")
    private var currentIndex = 0


    fun mainMenu() {
        try {
            loreBoton.setOnAction {
                explorarArchivos()
            }
            nuevoGalloBoton.setOnAction {
                openNewCharacterDialog()
                cambiarAvatar()

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

    @Throws(IOException::class)
    fun siguientePantalla() {
        val currentStage = jugarBoton.scene.window as Stage
        val fxmlLoader = FXMLLoader(javaClass.getResource("character-screen.fxml"))
        val scene = Scene(fxmlLoader.load())
        currentStage.title = "Selecciona tu personaje"
        currentStage.scene = scene
        currentStage.show()
    }

    @Throws(IOException::class)
    fun openNewCharacterDialog() {
        val dialog = javafx.scene.control.Dialog<ButtonType>()
        dialog.title = "Nuevo Personaje"
        val fxmlLoader = FXMLLoader(javaClass.getResource("newcharacter-popupv2.fxml"))
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

@Throws(IOException::class)
@FXML
fun cambiarAvatar() {
    val imageUrl = javaClass.getResourceAsStream("/images/${imageNames[currentIndex]}")
    if (imageUrl != null) {
        userAvatar.image = Image(imageUrl)
        nombreAvatar.text = labels[currentIndex]
        currentIndex = (currentIndex + 1) % imageNames.size
    } else {
        throw IOException("Image not found: /images/${imageNames[currentIndex]}")
    }
}


fun guardarNuevoGallo() {
    // Implement the function to save a new character
}

fun salir() {
    Platform.exit()
}
}

