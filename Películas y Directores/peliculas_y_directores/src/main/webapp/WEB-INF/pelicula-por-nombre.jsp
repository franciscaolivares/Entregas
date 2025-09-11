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
        <h1>Película</h1>
        <c:choose>
            <c:when test="${not empty director}">
                <h2>${nombre}</h2>
                <h3>Director: ${director}</h3>
            </c:when>
            <c:otherwise>
                <h2>La película no se encuentra en nuestra lista</h2>
            </c:otherwise>
        </c:choose>
    </body>
</html>
