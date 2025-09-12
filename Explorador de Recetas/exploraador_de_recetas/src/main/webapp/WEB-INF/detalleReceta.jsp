<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,java.text.*" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Recetas</title>
        <link rel="stylesheet" href="/css/estilos.css">
    </head>
    <body>
        <h1>Receta de ${nombre}</h1>
        <div class="imagenes">
            <c:choose>
                <c:when test="${nombre eq 'Pizza'}">
                    <img src="/images/pizza.png" alt="Imagen de Pizza" style="width:400px;height:400px;">
                </c:when>
                <c:when test="${nombre eq 'Espagueti'}">
                    <img src="/images/espagueti.png" alt="Imagen de Espagueti" style="width:400px;height:400px;">
                </c:when>
                <c:when test="${nombre eq 'Lasaña'}">
                    <img src="/images/lasaña.png" alt="Imagen de Lasaña" style="width:400px;height:400px;">
                </c:when>
            </c:choose>
        </div>
        <h2>Ingredientes:</h2>
        <ul>
            <c:forEach var="ingrediente" items="${ingredientes}">
                <li>${ingrediente}</li>
            </c:forEach>
        </ul>
        <a href="/recetas">Volver a la lista de recetas</a>
    </body>
</html>