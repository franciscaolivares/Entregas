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
        <h1> Detalle Canción ${cancion.titulo} </h1>
        <div class="lista-canciones">
                <h2>${cancion.titulo}</h2>
                <p>Artista: ${cancion.artista}</p>
                <p>Album: ${cancion.album}</p>
                <p>Género: ${cancion.genero}</p>
                <p>Idioma: ${cancion.idioma}</p>
                <form method="GET" action="/canciones/formulario/editar/${cancion.id}">
                    <button class="btn btn-secondary">
                        Actualizar
                    </button>  
                </form>      
        </div>
        <form method="POST" action="/canciones/eliminar/${cancion.id}">
            <input type="hidden" name="_method" value="DELETE">
            <button class="btn btn-danger">
            Eliminar
            </button>
        </form>    
        <a href="/canciones">Volver a lista de canciones.</a>
    </body>
</html>