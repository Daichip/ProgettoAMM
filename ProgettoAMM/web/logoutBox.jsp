<%-- 
    Document   : logoutBox
    Created on : 2-mag-2017, 11.02.46
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:set var="page" value="bacheca" scope="session"/>

<div id="logOut">
    <div id="imgLogOut">
        <img class="iconPic" title="fotoProfiloLogOut" alt="fotoProfiloLogOut" src="/ProgettoAMM/Assets/logOutPic.png">
    </div>
    <div id="nameLogOut">
        <h3><c:out value="${utente.nome} ${utente.cognome}"/></h3>
        <p><a href="Login?logout=true">Logout</a></p>
    </div>
</div>
