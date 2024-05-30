<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 28/05/2024
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Películas</title>
</head>
<body>
<h2>Lista de Películas</h2>
<form action="PeliculaServlet" method="get">
    <input type="text" name="searchQuery" placeholder="Buscar película...">
    <button type="submit">Buscar</button>
</form>
<table border="1">
    <tr>
        <th>Título</th>
        <th>Director</th>
        <th>Año de Publicación</th>
        <th>Rating</th>
        <th>Box Office</th>
        <th>Género</th>
        <th>Detalles</th>
        <th>Actores</th>
    </tr>
    <c:forEach var="pelicula" items="${peliculas}">
        <tr>
            <td><a href="DetallesServlet?id=${pelicula.idPelicula}">${pelicula.titulo}</a></td>
            <td>${pelicula.director}</td>
            <td>${pelicula.anoPublicacion}</td>
            <td>${pelicula.rating}/10</td>
            <td>$${pelicula.boxOffice}</td>
            <td>${pelicula.genero.nombre}</td>
            <td><a href="DetallesServlet?id=${pelicula.idPelicula}">Ver Detalles</a></td>
            <td><a href="ActoresServlet?idPelicula=${pelicula.idPelicula}">Ver Actores</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


