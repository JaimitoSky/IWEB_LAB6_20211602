<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 28/05/2024
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${tituloPelicula} - Actores</title>
</head>
<body>
<h1>Actores de la película: ${tituloPelicula}</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Año Nacimiento</th>
        <th>Ganador del Oscar</th>
    </tr>
    <c:forEach items="${actores}" var="actor">
        <tr>
            <td>${actor.idActor}</td>
            <td>${actor.nombre}</td>
            <td>${actor.apellido}</td>
            <td>${actor.anoNacimiento}</td>
            <td>${actor.premioOscar ? 'Sí' : 'No'}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

