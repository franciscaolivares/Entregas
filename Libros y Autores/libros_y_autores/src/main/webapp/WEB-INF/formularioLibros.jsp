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
        <h1>Formulario Libro</h1>
        <form method= "POST" action = "/procesa/libro" >  <%-- Recuerda el methodo ya sea get o post y el action es la ruta a la que va a ir --%>
            <div>
                <label for="nombre">Nombre del libro:</label>
                <input type="text" id="nombre" name="nombre">

                <label for="autor">Autor:</label>
                <input type="text" id="autor" name="autor">

                <button type="submit">Agregar Libro</button>  
            </div>          
        </form>
        <a href="/libros">Volver a la lista de libros</a>
    </body>
</html>