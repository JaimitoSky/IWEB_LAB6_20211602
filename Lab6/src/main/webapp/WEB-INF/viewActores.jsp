<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 28/05/2024
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Actores de la Película</title>
</head>
<body>
<h1>Actores de la Película</h1>
<table border="1">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Año de Nacimiento</th>
        <th>Premio Oscar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${actores}" var="actor">
        <tr>
            <td>${actor.nombre}</td>
            <td>${actor.apellido}</td>
            <td>${actor.anoNacimiento}</td>
            <td>${actor.premioOscar ? 'Sí' : 'No'}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
