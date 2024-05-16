import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class BaseDeDatosHandler(private val rutaBaseDeDatos: String) {

    private var connection: Connection? = null

    init {
        conectar()
        crearTablas()
    }

    private fun conectar() {
        try {
            Class.forName("org.sqlite.JDBC")
            connection = DriverManager.getConnection("jdbc:sqlite:$rutaBaseDeDatos")
            println("Conexión establecida con la base de datos")
        } catch (ex: ClassNotFoundException) {
            ex.printStackTrace()
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
    }

    private fun crearTablas() {
        crearTablaPalabras()
        crearTablaParticipantes()
        crearTablaBatallas()
    }

    private fun crearTablaPalabras() {
        val sql = """
            CREATE TABLE IF NOT EXISTS Palabras (
                palabra TEXT PRIMARY KEY
            );
        """.trimIndent()

        ejecutarSQL(sql, "Tabla Palabras")
    }

    private fun crearTablaParticipantes() {
        val sql = """
            CREATE TABLE IF NOT EXISTS Participantes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                urlFotoPerfil TEXT
            );
        """.trimIndent()

        ejecutarSQL(sql, "Tabla Participantes")
    }

    private fun crearTablaBatallas() {
        val sql = """
            CREATE TABLE IF NOT EXISTS Batallas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                fecha TEXT,
                participante1_id INTEGER,
                participante2_id INTEGER,
                palabrasUtilizadas TEXT,
                ganador_id INTEGER,
                FOREIGN KEY (participante1_id) REFERENCES Participantes(id),
                FOREIGN KEY (participante2_id) REFERENCES Participantes(id),
                FOREIGN KEY (ganador_id) REFERENCES Participantes(id)
            );
        """.trimIndent()

        ejecutarSQL(sql, "Tabla Batallas")
    }

    fun insertarPalabra(palabra: String) {
        val sql = "INSERT OR IGNORE INTO Palabras (palabra) VALUES (?);"
        ejecutarSQL(sql, "Palabra") { statement ->
            statement.setString(1, palabra)
        }
    }

    fun insertarParticipante(nombre: String, urlFotoPerfil: String) {
        val sql = "INSERT INTO Participantes (nombre, urlFotoPerfil) VALUES (?, ?);"
        ejecutarSQL(sql, "Participante") { statement ->
            statement.setString(1, nombre)
            statement.setString(2, urlFotoPerfil)
        }
    }

    fun insertarBatalla(fecha: String, participante1Id: Int, participante2Id: Int, palabrasUtilizadas: String, ganadorId: Int) {
        val sql = "INSERT INTO Batallas (fecha, participante1_id, participante2_id, palabrasUtilizadas, ganador_id) VALUES (?, ?, ?, ?, ?);"
        ejecutarSQL(sql, "Batalla") { statement ->
            statement.setString(1, fecha)
            statement.setInt(2, participante1Id)
            statement.setInt(3, participante2Id)
            statement.setString(4, palabrasUtilizadas)
            statement.setInt(5, ganadorId)
        }
    }

    private fun ejecutarSQL(sql: String, objeto: String, block: (statement: java.sql.PreparedStatement) -> Unit = {}) {
        try {
            val preparedStatement = connection?.prepareStatement(sql)
            block(preparedStatement!!)
            preparedStatement.executeUpdate()
            println("$objeto insertado correctamente en la base de datos")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
    }

}
