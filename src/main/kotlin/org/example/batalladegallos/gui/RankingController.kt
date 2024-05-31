package org.example.batalladegallos.gui

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import org.example.batalladegallos.Model.Participante

class RankingController {
    @FXML
    lateinit var avatarPlayer1: ImageView
    @FXML
    lateinit var namePlayer1: Label
    @FXML
    lateinit var scorePlayer1: Label

    @FXML
    lateinit var avatarPlayer2: ImageView
    @FXML
    lateinit var namePlayer2: Label
    @FXML
    lateinit var scorePlayer2: Label
    @FXML
    lateinit var salirBoton: Button

    fun initialize(player1Data: Participante, player2Data: Participante) {
        updatePlayerData(player1Data, avatarPlayer1, namePlayer1, scorePlayer1)
        updatePlayerData(player2Data, avatarPlayer2, namePlayer2, scorePlayer2)
    }

    private fun updatePlayerData(playerData: Participante, avatar: ImageView, name: Label, score: Label) {
        avatar.image = Image(playerData.urlFotoPerfil)
        name.text = playerData.nombre
        score.text = "Score: ${playerData.puntuacion}"
    }
    fun salirR() {
        salirBoton.setOnAction {
            val stage = salirBoton.scene.window as Stage
            stage.close()
        }
    }
}