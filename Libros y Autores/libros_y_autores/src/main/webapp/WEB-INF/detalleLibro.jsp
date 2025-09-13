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
        <h1>Libro ${nombre}</h1>
        <p>Nombre del libro: ${nombre}</p>
        <p>Autor: ${autor}</p>
        </ul>
        <a href="/libros">Volver a la lista de libros</a>
    </body>
</html>