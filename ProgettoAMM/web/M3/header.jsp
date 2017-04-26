<%-- 
    Document   : header
    Created on : 24-apr-2017, 11.58.50
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <div id="title">
        <h1>NerdBook</h1>
        <div id="logOut">
            <div id="imgLogOut">
                <img class="iconPic" title="fotoProfiloLogOut" alt="fotoProfiloLogOut" src="/ProgettoAMM/Assets/logOutPic.png">
            </div>
            <div id="nameLogOut">
                <h3>${utente.nome} ${utente.cognome}</h3>
                <p><a href="login.html" target="_blank">Logout</a></p>
            </div>
        </div>
    </div>
<!-- Possibile inclusione di nav.jsp -->
</header>