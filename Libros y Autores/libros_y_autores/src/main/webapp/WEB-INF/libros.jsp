<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,java.text.*" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Libros</title>
        <link rel="stylesheet" href="/css/estilos.css">

    </head>
    <body>
        <h1>Libros</h1>
        <ul>
            <c:forEach var="libro" items="${libros.keySet()}">
                <li><a href="/libros/${libro}">${libro}</a></li>
                <%--<li>${libro} | ${libros[libro]}</li>--%>
                <%-- Es para acceder al value, libro es la clave, para acceder a su vvalor se ocupa el corcchete  --%>
            </c:forEach>
        </ul>
        <a href="/libros/formulario">Agregar Libro</a>
    </body>
</html>