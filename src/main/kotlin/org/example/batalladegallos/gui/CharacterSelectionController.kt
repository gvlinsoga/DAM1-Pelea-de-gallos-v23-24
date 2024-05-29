package org.example.batalladegallos.gui

import javafx.collections.ListChangeListener
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import javafx.scene.image.ImageView
import javafx.stage.Stage
import org.example.batalladegallos.Model.Participante

class CharacterSelectionController {

    @FXML
    var avatarPlayer1: ImageView = ImageView()

    @FXML
    var avatarPlayer2: ImageView = ImageView()

    @FXML
    lateinit var iniciarBatallaBoton: Button
    private var nombre = ""
    var siguientePantalla = ""
    var siguienteTitulo = ""

    @FXML
     var characterPlayer1: MenuButton= MenuButton()
    @FXML
    val characterPlayer2: MenuButton = MenuButton()

    companion object {
        lateinit var instance: CharacterSelectionController
    }
    init {
        instance = this
        GlobalData.participants.addListener(ListChangeListener<Participante> {
            updateMenuItems()
        })
    }

private fun updateMenuItems() {
    println("miauu participantes: ${GlobalData.participants}")
    GlobalData.participants.forEach { participant ->
        val menuItem1 = MenuItem(participant.nombre)
        val menuItem2 = MenuItem(participant.nombre)
        characterPlayer1.items.add(menuItem1)
        characterPlayer2.items.add(menuItem2)
        characterPlayer1.setOnAction {
            println("Selected character for Player 1: ${participant.nombre}")
        }
        characterPlayer2.setOnAction {
            println("Selected character for Player 2: ${participant.nombre}")
        }
    }
}

fun initialize() {
    updateMenuItems()
}

fun addParticipants() {
    println("participants: ${GlobalData.participants}")
    GlobalData.participants.forEach { participant ->
        val menuItem = MenuItem(participant.nombre)
        characterPlayer1.items.add(menuItem)
        characterPlayer2.items.add(menuItem)
        menuItem.setOnAction {
            println("Selected character: ${participant.nombre}")
        }

    }
}

/*
    fun agregarGalloAlMenu() {

        println("participantes: ${menuController.getParticipants()}")
        // Get the list of participants from the MenuController
        val participants = menuController.getParticipants()
        println("participantes: $participants")
        // Add a MenuItem for each participant
        participants.forEach { participant ->
            characterPlayer1.items.add(MenuItem(participant.nombre))
        }


    } */




        /*  //HAY QUE CAMBIAR TAMBIÉN ESTO, ES SUPONIENDO QUE EL GALLO ESTÁ CREADO. MODIFICAAAR
          private var gallosDisponibles: MutableList<Participante> = mutableListOf(
              Participante("Gallo1", "", 0), Participante("Gallo2", "", 0)
          )
          private var gallosSeleccionados: MutableList<Participante> = mutableListOf()

          fun seleccionarGallo(): Boolean {
              val gallo = gallosDisponibles.find { it.nombre == nombre }
              if (gallo != null) {
                  gallosSeleccionados.add(gallo)
                  gallosDisponibles.remove(gallo)
                  return true
              }
              return false
          }

          fun obtenerGallosDisponibles(): List<Participante> {
              return gallosDisponibles
          }

          fun obtenerGallosSeleccionados(): List<Participante> {
              return gallosSeleccionados
          }

          fun resetearSeleccion() {
              gallosDisponibles.addAll(gallosSeleccionados)
              gallosSeleccionados.clear()
          }

          fun hayGallosDisponibles(): Boolean {
              return gallosDisponibles.isNotEmpty()
          }

          fun iniciarBatalla() {
              iniciarBatallaBoton.setOnAction {
                  println("Iniciando batalla con los siguientes gallos:")
                  siguientePantalla = "/org/example/batalladegallos/gui/game-screen.fxml"
                  siguienteTitulo = "Batalla de Gallos - Arena de Combate"
                  val currentStage = iniciarBatallaBoton.scene.window as Stage
                  val fxmlLoader = FXMLLoader(javaClass.getResource(siguientePantalla))
                  val newScene = Scene(fxmlLoader.load())
                  currentStage.title = siguienteTitulo
                  currentStage.scene = newScene
                  currentStage.show()

              }

          }

          fun main() {
              val scanner = Scanner(System.`in`)
              val controller = CharacterSelectionController()
              var continuar = true

              while (continuar && controller.hayGallosDisponibles()) {
                  println("Gallos disponibles para seleccionar:")
                  controller.obtenerGallosDisponibles().forEach {
                      println("${it.nombre} - ${it.urlFotoPerfil}")
                  }

                  println("Ingrese el apodo del gallo a seleccionar o 'exit' para salir:")
                  val input = scanner.nextLine()

                  if (input == "exit") {
                      println("Finalizando la selección de personajes.")
                      continuar = false
                  } else if (controller.seleccionarGallo()) {
                      println("Gallo seleccionado con éxito.")
                  } else {
                      println("Gallo no disponible o ya seleccionado.")
                  }
              }

              println("Selección finalizada. Gallos seleccionados:")
              controller.obtenerGallosSeleccionados().forEach {
                  println("${it.nombre} - ${it.urlFotoPerfil}")
              }
          } */


    fun iniciarBatalla(actionEvent: ActionEvent) {
        iniciarBatallaBoton.setOnAction {
            println("Iniciando batalla con los siguientes gallos:")
            siguientePantalla = "/org/example/batalladegallos/gui/game-screen.fxml"
            siguienteTitulo = "Batalla de Gallos - Arena de Combate"
            val currentStage = iniciarBatallaBoton.scene.window as Stage
            val fxmlLoader = FXMLLoader(javaClass.getResource(siguientePantalla))
            val newScene = Scene(fxmlLoader.load())
            currentStage.title = siguienteTitulo
            currentStage.scene = newScene
            currentStage.show()
    }

    }

    fun seleccionarGallo1(actionEvent: ActionEvent) {
        characterPlayer1.items.forEach { menuItem ->
            menuItem.setOnAction {
                nombre = menuItem.text
                println("Gallo seleccionado: $nombre")
            }
        }
    }


}

