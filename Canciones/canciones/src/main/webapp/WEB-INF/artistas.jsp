<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,java.text.*" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>App Canciones</title>
        <link rel="stylesheet" href="/css/estilos.css">
    </head>
    <body>
        <h1>Listado de Artistas</h1>
        <table>
        <thead>
            <tr>
                <th>Artista</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="artista" items="${artistas}">
            <tr>
                <td>${artista.nombre} ${artista.apellido}</td>
                <td >
                    <a href="/artistas/detalle/${artista.id}">Ver detalle</a>
            </tr>
            </c:forEach>
        </tbody>
        </table>
        <a href="/canciones">Ir a canciones </a>
    </body>
</html>