<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Película por nombre</title>
    </head>
    <body>
        <h1>Película por el director: ${nombre}</h1>
        <ul>
            <c:forEach var="peliculaPor" items="${peliculas}">
                <li>${peliculaPor}</li>
            </c:forEach>
        </ul>
    </body>
</html>
