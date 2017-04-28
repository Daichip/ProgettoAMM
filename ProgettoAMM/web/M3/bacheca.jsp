<%-- 
    Document   : bacheca
    Created on : 26-apr-2017, 11.11.10
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook: Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Davide Fara">
        <meta name="keywords" content="nerdbook Nerd Book social network friends bacheca spam">
        <link rel="stylesheet" type="text/css" href="/ProgettoAMM/M2/style.css" media="screen">
    </head>
    <body>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="sidebar1.jsp"/>
        
        <div class="bodyBacheca" id="divBody">
            <div class="post">
                <h1>Post:</h1>
            </div>
            <div class="post" id="post1">
                <img class="profilePic" title="fotoProfilo1" alt="fotoProfiloUt1" src="/ProgettoAMM/Assets/marioRossi.jpg">
                <h3>Mario "Mario Mario" Rossi ha scritto:</h3>
                <p>Mamma mia!</p>
            </div>
            <div class="post" id="post2">
                <img class="profilePic" title="fotoProfilo2" alt="fotoProfiloUt2" src="/ProgettoAMM/Assets/lucaVerdi.jpg">
                <h3>Luca "Link" Verdi ha condiviso una foto:</h3>
                <img id="linkedImg" title="foto_condivisa" alt="Selfie" src="/ProgettoAMM/Assets/linkedImg.jpg">
                <p>Selfie with a friend(?)</p>
            </div>
            <div class="post" id="post3">
                <img class="profilePic" title="fotoProfilo3" alt="fotoProfiloUt3" src="/ProgettoAMM/Assets/carloRossi.gif">
                <h3>Carlo "Shy Guy" Rossi ha condiviso un link:</h3>
                <p>Guarda <a href="https://en.wikipedia.org/wiki/List_of_recurring_Mario_franchise_enemies#Shy_Guy" target="_blank">https://en.wikipedia.org/wiki/List_of_recurring_Mario_franchise_enemies#Shy_Guy</a> per scoprire qualcosa su di me!</p>
            </div>
        </div>
    </body>
</html>
