<%-- 
    Document   : profilo
    Created on : 26-apr-2017, 11.57.13
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook: Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Davide Fara">
        <meta name="keywords" content="nerdbook Nerd Book social network friends profilo profile my profile">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="sidebar1.jsp"/>

        <div class="bodyProfilo" id="divBody">  
            <img id="profilePic" title="profilePic" alt="profilePic" src="/ProgettoAMM/Assets/profPicIcon.png">
            <form id="profileForm" action="#" method="post">
                <label for="userNome">Nome</label>
                <input type="text" name="userNome" id="userNome"/>
                <label for="userCognome">Cognome</label>
                <input type="text" name="userCognome" id="userCognome"/>
                <label for="userDataNascita">Nato il</label>
                <input type="date" name="userDataNascita" id="userDataNascita"/>
                <label for="userFraseDescrizione">Frase di presentazione</label>
                <textarea name="userFraseDescrizione" id="userFraseDescrizione"></textarea>
                <label for="userPass">Password</label>
                <input type="password" name="userPass" id="userPass"/>
                <label for="userConfermaPass">Conferma la Password</label>
                <input type="password" name="userConfermaPass" id="userConfermaPass"/>
                <button type="submit">Invia</button>
            </form>
        </div>
    </body>
</html>

