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
        <h1>Recetas</h1>
        <ul>
            <c:forEach var="receta" items="${listaRecetas}">
                <li>${receta}</li>
                <a href="/recetas/${receta}">Ver receta</a>
            </c:forEach>
        </ul>
    </body>
</html>