package org.example.BatallaDeGallos.GUI
import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import org.example.BatallaDeGallos.Model.Palabras

class ArenaController {

    @FXML
    private lateinit var comboBoxJugador1: ComboBox<String>

    @FXML
    private lateinit var comboBoxJugador2: ComboBox<String>

    private val rutaArchivo = "/Users/adrian.galinsoga/Desktop/DAM1-Pelea-de-gallos-v23-24/src/main/kotlin/org/example/BatallaDeGallos/Persistence/TirantLoBlanc_Caps1_99.txt"

    fun iniciarBatalla() {
        val archivoHandler = Palabras(rutaArchivo)
        val palabrasUnicas = archivoHandler.obtenerPalabrasUnicas()

        comboBoxJugador1.items.addAll(palabrasUnicas.shuffled())
        comboBoxJugador2.items.addAll(palabrasUnicas.shuffled())
    }
}

