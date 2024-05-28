package org.example.batalladegallos.gui

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.File
import java.io.IOException
import java.nio.file.Paths

class MenuController {
    @FXML
    var loreBoton: Button = Button()
    lateinit var jugarBoton: Button
    lateinit var nuevoGalloBoton: Button
    var rankingBoton: Button = Button()
    var salirBoton: Button = Button()
    var initNoseqe = ""




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
        val fxmlLoader = FXMLLoader(javaClass.getResource("character-selection.fxml"))
        val scene = Scene(fxmlLoader.load())
        currentStage.title = "Batalla de Gallos - Selección de Personajes"
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

    @FXML
    private lateinit var logo: ImageView

    @FXML
    private var userAvatar: ImageView = ImageView()

    @FXML
    private var nombreAvatar: Label = Label()

    // Listas de nombres de imágenes y etiquetas correspondientes
    private val imageNames = listOf("mrGrump.png", "mittens.png", "angryCat.png", "scaredy.png", "catspurrov.png")
    private val labels = listOf("Mr Grump", "Mittens", "Angry Cat", "Scaredy", "Catspurrov")
    private var currentAvatarIndex = 0

    @Throws(IOException::class)
@FXML
fun cambiarAvatar() {
    currentAvatarIndex = (currentAvatarIndex + 1) % imageNames.size

    val imageName = imageNames[currentAvatarIndex]
     val label = labels[currentAvatarIndex]
    val image = (Image(Paths.get("src/main/resources/org/example/batalladegallos/images/${imageName}").toUri().toString()))
        userAvatar.image = image
        nombreAvatar.text = label
}


@FXML
var userName = TextField()
    var cumField = DatePicker()

fun guardarGallo() {
    val nombre = userName.text
    val cumpleaños = cumField.value
    println("Nombre: $nombre, Cumpleaños: $cumpleaños")
    // Guardar el nuevo gallo
    // Cerrar la ventana
    // Mostrar mensaje de éxito
    // Limpiar los campos
}


    @FXML
    fun verRanking() {
        val stage = (salirBoton.scene.window as Stage)
        val fxmlLoader = FXMLLoader(javaClass.getResource("/path_to_ranking_view.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = "Batalla de Gallos - Ranking"
        stage.scene = scene
        stage.show()

        // Get the controller instance
        val rankingController = fxmlLoader.getController<RankingController>()
        // Now you can call methods on rankingController
    }


fun salir() {
    Platform.exit()
}

}

