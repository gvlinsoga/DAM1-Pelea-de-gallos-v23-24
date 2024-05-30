package org.example.batalladegallos.gui

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import javafx.scene.control.ProgressBar
import javafx.scene.text.Text
import javafx.stage.Stage
import javafx.util.Duration
import org.example.batalladegallos.Model.Palabras
import org.example.batalladegallos.Model.Participante
import org.example.batalladegallos.gui.RankingController

class GameController {

    @FXML
    lateinit var timerPlayer1: ProgressBar

    @FXML
    lateinit var timerPlayer2: ProgressBar

    @FXML
    var roundCounter: Text  = Text()

    @FXML
    lateinit var player1Name: Text

    @FXML
    lateinit var player2Name: Text

    private lateinit var player1: Participante
    private lateinit var player2: Participante

    private var currentRound = 0
    private var currentPlayer = 1

    var siguientePantalla = ""
    var siguienteTitulo = ""

    @FXML
    lateinit var goRankingButton: Button

    fun initialize(player1: Participante, player2: Participante) {
        this.player1 = player1
        this.player2 = player2
        updateMenuItemsWords()
        startRound()
    }

    @FXML
    private lateinit var menuPalabrasPlayer1: MenuButton
    @FXML
    private lateinit var menuPalabrasPlayer2: MenuButton

    private val palabrasPlayer1 = Palabras("Rima 1", mutableListOf("Palabra 1", "Palabra 2", "Palabra 3"))
    private val palabrasPlayer2 = Palabras("Rima 2", mutableListOf("Palabra 4", "Palabra 5", "Palabra 6"))

    @FXML
    var aplaudimetroProgress: ProgressBar = ProgressBar()
    @FXML
    var aplausosContador: Label = Label()
    @FXML
    var rondaCounter: Label = Label()
    @FXML
    var tiempoPlayer1 : Label = Label()
    @FXML
    var tiempoPlayer2 : Label = Label()

    private fun updateMenuItemsWords() {
        // Clear the existing items
        menuPalabrasPlayer1.items.clear()
        menuPalabrasPlayer2.items.clear()

        // Add the words to the menu for player 1
        palabrasPlayer1.palabrasDisponibles.forEach { word ->
            val menuItem = MenuItem(word)
            menuPalabrasPlayer1.items.add(menuItem)
            menuItem.setOnAction {
                // Disable the menu item and change its text color to gray
                menuItem.isDisable = true
                menuItem.style = "-fx-text-fill: gray;"
                // Add the word to the list of used words
                palabrasPlayer1.palabrasUsadas.add(word)
                // Remove the word from the list of available words
                palabrasPlayer1.palabrasDisponibles.remove(word)
            }
        }

        // Add the words to the menu for player 2
        palabrasPlayer2.palabrasDisponibles.forEach { word ->
            val menuItem = MenuItem(word)
            menuPalabrasPlayer2.items.add(menuItem)
            menuItem.setOnAction {
                // Disable the menu item and change its text color to gray
                menuItem.isDisable = true
                menuItem.style = "-fx-text-fill: gray;"
                // Add the word to the list of used words
                palabrasPlayer2.palabrasUsadas.add(word)
                // Remove the word from the list of available words
                palabrasPlayer2.palabrasDisponibles.remove(word)
            }
        }
    }

    private fun startRound() {
        currentRound++
        roundCounter.text = "Round: $currentRound"
        player1Name.text = player1.nombre
        player2Name.text = player2.nombre

        startTimer()
    }

private fun startTimer() {
    val players = listOf(timerPlayer1, timerPlayer2)
    val labels = listOf(tiempoPlayer1, tiempoPlayer2) // Assuming you have a label for player 2
    val timeline = Timeline(
        KeyFrame(Duration.seconds(1.0), EventHandler<ActionEvent> {
            val currentPlayerProgressBar = players[currentPlayer - 1]
            val currentPlayerLabel = labels[currentPlayer - 1] // Get the label for the current player
            currentPlayerProgressBar.progress -= 1.0 / 30
            if (currentPlayerProgressBar.progress <= 0) {
                currentPlayerProgressBar.progress = 1.0
                currentPlayerProgressBar.style = "-fx-accent: gray;" // Disable current player's progress bar
                currentPlayer = 3 - currentPlayer // Switch to the other player
                val nextPlayerProgressBar = players[currentPlayer - 1]
                nextPlayerProgressBar.progress = 1.0
                nextPlayerProgressBar.style = "-fx-accent: blue;" // Enable next player's progress bar
                if (currentPlayer == 1) {
                    currentRound++
                    if (currentRound < 3) {
                        startRound()
                    } else {
                        // Switch to ranking screen
                    }
                }
            }
            // Update the label with the remaining seconds for the current player
            currentPlayerLabel.text = "${(currentPlayerProgressBar.progress * 30).toInt()} segundos restantes"
        })
    )
    timeline.cycleCount = Timeline.INDEFINITE
    timeline.play()
}

    private fun irRanking() {

    }

    fun goRanking() {
        siguientePantalla = "/org/example/batalladegallos/gui/ranking-screen.fxml"
        siguienteTitulo = "Batalla de Gallos - Ranking"
        val stage = (goRankingButton.scene.window as Stage)
        val fxmlLoader = FXMLLoader(javaClass.getResource(siguientePantalla))
        val scene = Scene(fxmlLoader.load())
        stage.title = siguienteTitulo
        stage.scene = scene
        stage.show()
        val rankingController = fxmlLoader.getController<RankingController>()
    }
}