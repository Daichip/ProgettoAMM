<%-- 
    Document   : header
    Created on : 24-apr-2017, 11.58.50
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <div id="title">
        <h1>NerdBook</h1>
        <c:set var="title" value="Bacheca" scope="request"/>
        <jsp:include page="logoutBox.jsp"/>
    </div>
    <c:set var="title" value="Bacheca Personale" scope="request"/>
    <jsp:include page="nav.jsp"/>
</header>