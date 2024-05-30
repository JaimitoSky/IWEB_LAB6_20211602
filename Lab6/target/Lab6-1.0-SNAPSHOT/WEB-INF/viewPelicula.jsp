<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 28/05/2024
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${pelicula.titulo}</title>
</head>
<body>
<h1>Detalles de la Película: ${pelicula.titulo}</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <td>${pelicula.idPelicula}</td>
    </tr>
    <tr>
        <th>Título</th>
        <td>${pelicula.titulo}</td>
    </tr>
    <tr>
        <th>Director</th>
        <td>${pelicula.director}</td>
    </tr>
    <tr>
        <th>Año de Publicación</th>
        <td>${pelicula.anoPublicacion}</td>
    </tr>
    <tr>
        <th>Rating</th>
        <td>${pelicula.rating}</td>
    </tr>
    <tr>
        <th>Box Office</th>
        <td>${pelicula.boxOffice}</td>
    </tr>
    <tr>
        <th>Género</th>
        <td>${pelicula.genero.nombre}</td>
    </tr>
    <tr>
        <td colspan="2"><a href="ViewActores.jsp?idPelicula=${pelicula.idPelicula}">Ver Actores</a></td>
    </tr>
</table>
</body>
</html>
