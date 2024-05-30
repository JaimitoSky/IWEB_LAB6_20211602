package Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import Dao.PeliculaDAO;
import Modelos.Pelicula;

@WebServlet(name = "PeliculaServlet", urlPatterns = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    private PeliculaDAO peliculaDAO = new PeliculaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("search");
        List<Pelicula> peliculas = peliculaDAO.buscarPeliculas(searchQuery);
        request.setAttribute("peliculas", peliculas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listaPeliculas.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementar lógica POST si es necesario
    }
}

