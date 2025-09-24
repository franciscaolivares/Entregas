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
        <h1>Detalle Artista ${artista.nombre} ${artista.apellido}</h1>
        <div class="detalle-artista">
                <p>Artista: ${artista.nombre} ${artista.apellido}</p>
                <p>Biografía: ${artista.biografia}</p>     
        </div>
        <h2>Canciones del artista</h2>
        <div class="lista-canciones">
            <ul>
                <c:forEach var="cancion" items="${artista.canciones}">
                    <li>${cancion.titulo} 
                        <a href="/canciones/detalle/${cancion.id}">Ver detalle </a>
                    </li>
                </c:forEach>
                <c:if test="${empty artista.canciones}">
                    <li>El artista no tiene canciones</li>
                </c:if>
            </ul>
        </div>            
        <a href="/artistas">Volver a lista de artistas.</a>
    </body>
</html>