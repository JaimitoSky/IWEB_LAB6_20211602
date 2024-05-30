package Dao;

import Modelos.Pelicula;
import Modelos.Genero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "tucontraprofe"); //nota : cuando abro el servidor, se muestra la tabla pero sin los datos
    }

    public Pelicula buscarPorId(int id) {
        String sql = "SELECT p.*, g.nombre AS genero_nombre FROM peliculas p " +
                "INNER JOIN generos g ON p.idGenero = g.idGenero " +
                "WHERE p.idPelicula = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Genero genero = new Genero(rs.getInt("idGenero"), rs.getString("genero_nombre"));
                return new Pelicula(
                        rs.getInt("idPelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anoPublicacion"),
                        rs.getDouble("rating"),
                        rs.getDouble("boxOffice"),
                        genero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  List<Pelicula> buscarPeliculas(String searchQuery) {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.idGenero, g.nombre AS genero_nombre " +
                "FROM pelicula p INNER JOIN genero g ON p.idGenero = g.idGenero " +
                "WHERE p.titulo LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + searchQuery + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Genero genero = new Genero(rs.getInt("idGenero"), rs.getString("genero_nombre"));
                Pelicula pelicula = new Pelicula(
                        rs.getInt("idPelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anoPublicacion"),
                        rs.getDouble("rating"),
                        rs.getDouble("boxOffice"),
                        genero);
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }
}
