<%-- 
    Document   : filter
    Created on : 1-giu-2017, 12.34.07
    Author     : Davide Fara
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<json:array>
    <c:forEach var="utente" items="${listaUtenti}">
        <json:object>
            <json:property name="nome" value="${utente.nome}"/>
            <json:property name="cognome" value="${utente.cognome}"/>
            <json:property name="password" value="${utente.password}"/>
            <json:property name="confermaPassword" value="${utente.confermaPassword}"/>
            <json:property name="frasePresentazione" value="${utente.frasePresentazione}"/>
            <json:property name="dataNascita" value="${utente.dataNascita}"/>
            <json:property name="urlFotoProfilo" value="${utente.urlFotoProfilo}"/>
            <json:property name="username" value="${utente.username}"/>
            <json:property name="id" value="${utente.id}"/>
        </json:object>
    </c:forEach>
</json:array>