package org.example.batalladegallos.gui

import javafx.fxml.FXML
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import org.example.batalladegallos.Model.Gallo
import javafx.util.Callback

class RankingController {
    @FXML
    private lateinit var listViewRanking: ListView<Gallo>

    private val ranking: List<Gallo> = listOf()

    @FXML
    fun initialize() {
        configurarListView()
        cargarRanking()
    }

    private fun configurarListView() {
        listViewRanking.cellFactory = Callback<ListView<Gallo>, ListCell<Gallo>> {
            object : ListCell<Gallo>() {
                private val imageView = ImageView()
                override fun updateItem(gallo: Gallo?, empty: Boolean) {
                    super.updateItem(gallo, empty)
                    if (empty || gallo == null) {
                        text = null
                        graphic = null
                    } else {
                        imageView.image = Image(gallo.urlFotoPerfil, 50.0, 50.0, true, true)
                        text = "${gallo.apodo} - ${gallo.puntuacion}"
                        graphic = imageView
                    }
                }
            }
        }
    }

    private fun cargarRanking() {
        val rankingOrdenado = ranking.sortedByDescending { it.puntuacion }
        listViewRanking.items.clear()
        listViewRanking.items.addAll(rankingOrdenado as Collection<Gallo>)
    }
}

