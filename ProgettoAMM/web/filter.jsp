<%-- 
    Document   : filter
    Created on : 1-giu-2017, 12.34.07
    Author     : Davide Fara
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="utente" items="${utList}">
        <json:object>
            <json:property name="nome" value="${utente.nome}"/>
            <json:property name="cognome" value="${utente.cognome}"/>
            <json:property name="id" value="${utente.id}"/>
        </json:object>
    </c:forEach>
</json:array>