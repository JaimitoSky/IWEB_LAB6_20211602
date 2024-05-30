package Dao;

import Modelos.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "tucontraprofe");
    }

    public List<Actor> obtenerActoresPorPelicula(int idPelicula) {
        List<Actor> actores = new ArrayList<>();
        String sql = "SELECT a.*, p.titulo FROM Actor a " +
                "INNER JOIN Protagonistas pa ON a.idActor = pa.idActor " +
                "INNER JOIN Pelicula p ON pa.idPelicula = p.idPelicula " +
                "WHERE pa.idPelicula = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPelicula);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                actores.add(new Actor(
                        rs.getInt("idActor"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("anoNacimiento"),
                        rs.getBoolean("premioOscar")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actores;
    }
}

