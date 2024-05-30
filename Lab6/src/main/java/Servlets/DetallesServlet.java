package Servlets;

import Modelos.Pelicula;
import Dao.PeliculaDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetallesServlet", urlPatterns = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    private PeliculaDAO peliculaDAO = new PeliculaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("id"));
        Pelicula pelicula = peliculaDAO.buscarPorId(idPelicula);
        request.setAttribute("pelicula", pelicula);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewPelicula.jsp");
        dispatcher.forward(request, response);
    }
}

