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
        <c:set var="page" value="Descrizione" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="sidebar1.jsp"/>

        <c:if test="${profileError == true}">
            <div id="profileError">Devi essere loggato per vedere questa pagina. Clicca su <a href="Login"> Login </a> per loggarti</div>
        </c:if>
        <c:if test="${profileError != true} && ${update != true}">                
            <div class="bodyProfilo" id="divBody">  
                <img id="profilePic" title="profilePic" alt="profilePic" src="/ProgettoAMM/Assets/profPicIcon.png">
                <form id="profileForm" action="Profilo?update" method="post">
                    <label for="userNome">Nome</label>
                    <input type="text" name="userNome" id="userNome" value="${utente.nome}"/>
                    
                    <label for="userCognome">Cognome</label>
                    <input type="text" name="userCognome" id="userCognome" value="${utente.cognome}"/>
                    
                    <label for="userURLPic">URL foto</label>
                    <input type="text" name="userURLPic" id="userURLPic" value="${utente.urlFotoProfilo}"/>
                    
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" value="${utente.username}"/>
                    
                    <label for="userDataNascita">Nato il</label>
                    <input type="date" name="userDataNascita" id="userDataNascita" value="${utente.dataNascita}"/>
                    
                    <label for="userFraseDescrizione">Frase di presentazione</label>
                    <textarea name="userFraseDescrizione" id="userFraseDescrizione">${utente.frasePresentazione}</textarea>
                    
                    <label for="userPass">Password</label>
                    <input type="password" name="userPass" id="userPass" value="${utente.password}"/>
                    
                    <label for="userConfermaPass">Conferma la Password</label>
                    <input type="password" name="userConfermaPass" id="userConfermaPass" value="${utente.confermaPassword}"/>
                    
                    <button type="submit">Aggiorna</button>
                </form>
            </div>
        </c:if> 
        <c:if test="${update == true}">                
            <div class="bodyProfilo" id="divBody">  
                <img id="profilePic" title="profilePic" alt="profilePic" src="/ProgettoAMM/Assets/profPicIcon.png">
                <form id="profileForm" action="Profilo?update" method="post">
                    <label for="userNome">Nome</label>
                    <input type="text" name="userNome" id="userNome" value="${userNome}"/>
                    
                    <label for="userCognome">Cognome</label>
                    <input type="text" name="userCognome" id="userCognome" value="${userCognome}"/>
                    
                    <label for="userURLPic">URL foto</label>
                    <input type="text" name="userURLPic" id="userURLPic" value="${userURLPic}"/>
                    
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" value="${username}"/>
                    
                    <label for="userDataNascita">Nato il</label>
                    <input type="date" name="userDataNascita" id="userDataNascita" value="${userDataNascita}"/>
                    
                    <label for="userFraseDescrizione">Frase di presentazione</label>
                    <textarea name="userFraseDescrizione" id="userFraseDescrizione">${userFraseDescrizione}</textarea>
                    
                    <label for="userPass">Password</label>
                    <input type="password" name="userPass" id="userPass" value="${userPass}"/>
                    
                    <label for="userConfermaPass">Conferma la Password</label>
                    <input type="password" name="userConfermaPass" id="userConfermaPass" value="${userConfermaPass}"/>
                    
                    <button type="submit">Aggiorna</button>
                </form>
                <c:if test="${update == true}">
                    <div id="validate">Update riuscito!</div>
                </c:if>
            </div>
        </c:if> 
    </body>
</html>

