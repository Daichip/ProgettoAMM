<%-- 
    Document   : login
    Created on : 26-apr-2017, 11.56.55
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook: Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Davide Fara">
        <meta name="keywords" content="nerdbook Nerd Book social network friends login access sign-in">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <header class="hiddenHeader">
            <div title="login">
                <h1>Login</h1>
            </div>
            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="nav.jsp"/>
        </header>
        
        <div id="contPost">
            <div id="preForm">
                <img id="logoImg" title="NerdBookLogo" alt="LogoPic" src="/ProgettoAMM/Assets/logoNerdBook.jpg">
                <h1>NerdBook</h1>
            </div>
            <div id="divBody">
                <form class="dataForm" id="loginForm" action="#" method="post">
                    <div id="insertData">
                        <label for="userId">Nome Utente</label>
                        <input type="text" name="userId" id="userId" placeholder="Inserire il nome utente"/>
                        <label for="userPswd">Password</label>
                        <input type="password" name="userPswd" id="userPswd" placeholder="Inserire la password"/>
                    </div>
                    <button id="subButton" type="submit">Invia</button>
                </form>
            </div>
        </div>
    </body>
</html>
