<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,java.text.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro y login</title>
        <link rel="stylesheet" href="/css/estilos.css">
    </head>
    <body>
    <div class="Registro">
            <form:form action="/procesa/registro" modelAttribute="usuario" method="post">
                <h2>Registro</h2>
                <div>
                    <form:label  path="nombreUsuario">Usuario:</form:label>
                    <form:input path="nombreUsuario" />
                    <form:errors path="nombreUsuario" />
                </div>
                <div>
                    <form:label path="contrasenia">Contraseña:</form:label>
                    <form:password path="contrasenia" />
                    <form:errors path="contrasenia" />
                </div>
                <div>
                    <form:label path="confirmarContrasenia">Confirmar Contraseña:</form:label>
                    <form:password path="confirmarContrasenia" />
                    <form:errors path="confirmarContrasenia" />
                </div>
                <div>
                    <form:label path="correo">Correo:</form:label>
                    <form:input path="correo" />
                    <form:errors path="correo" />
                </div>
                <div>
                    <form:label path="nombre">Nombre:</form:label>
                    <form:input path="nombre" />
                    <form:errors path="nombre" />
                </div>
                <div>
                    <form:label path="apellido">Apellido:</form:label>
                    <form:input path="apellido" />
                    <form:errors path="apellido" />
                </div>
                <div>
                    <form:label path="fechaNacimiento">Fecha de Nacimiento:</form:label>
                    <form:input path="fechaNacimiento" />
                    <form:errors path="fechaNacimiento" />
                </div>
                <div>
                    <button type="submit">Registrarse</button>
                    </div>
            </form:form>
        </div>
            <form:form action="/procesa/login" modelAttribute="usuario" method="post">
                <h2>Login</h2>
                <div>
                    <form:label path="nombreUsuario">Usuario:</form:label>
                    <form:input path="nombreUsuario" />
                    <form:errors path="nombreUsuario" />
                </div>
                <div>
                    <form:label path="contrasenia">Contraseña:</form:label>
                    <form:password  path="contrasenia" />
                    <form:errors path="contrasenia" />
                    <c:if test="${not empty error}">
                        <span style="color:red">${error}</span>
                    </c:if>
                </div>
                <div>
                    <button type="submit">Iniciar Sesión</button>
                </div>
            </form:form>
    </body>
</html>