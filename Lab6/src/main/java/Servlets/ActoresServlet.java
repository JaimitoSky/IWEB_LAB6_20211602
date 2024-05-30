package Servlets;
import Dao.ActorDAO;  // Paquetes en minúsculas
import Modelos.Actor;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ActoresServlet", urlPatterns = "/ActoresServlet")
public class ActoresServlet extends HttpServlet {
    private final ActorDAO actorDAO = new ActorDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPeliculaParam = request.getParameter("idPelicula");
        if (idPeliculaParam != null) {
            try {
                int idPelicula = Integer.parseInt(idPeliculaParam);
                List<Actor> actores = actorDAO.obtenerActoresPorPelicula(idPelicula);
                request.setAttribute("actores", actores);
                request.setAttribute("tituloPelicula", "El Padrino");
                request.getRequestDispatcher("/WEB-INF/listaActores.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película inválido.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película requerido.");
        }    }


}
