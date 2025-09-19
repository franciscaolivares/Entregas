<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,java.text.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>App Canciones</title>
        <link rel="stylesheet" href="/css/estilos.css">
    </head>
    <body>
        <h1> Nueva canción ${cancion.titulo} </h1>
        <div class="formulario">
        <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="nuevaCancion">
            <div>
                <form:label path="titulo">
                    Título:
                </form:label> 
                <form:input path="titulo" type="text"/>
                <form:errors path="titulo"/>
            </div>   
            <div>
                <form:label path="">
                    Artista:
                </form:label> 
                <form:input path="artista" type="text"/>
                <form:errors path="artista"/>
            </div>  
            <div>
                <form:label path="titulo">
                    Álbum:
                </form:label> 
                <form:input path="album" type="text"/>
                <form:errors path="album"/>
            </div>
            <div>
                <form:label path="titulo">
                    Género:
                </form:label> 
                <form:input path="genero" type="text"/>
                <form:errors path="genero"/>
            </div>   
            <div>
                <form:label path="titulo">
                    Idioma:
                </form:label> 
                <form:input path="idioma" type="text"/>
                <form:errors path="idioma"/>
            </div> 
            <button>Agregar</button> 
        </form:form>                                       
        </div>
        <a href="/canciones">Volver a lista de canciones.</a>
    </body>
</html>