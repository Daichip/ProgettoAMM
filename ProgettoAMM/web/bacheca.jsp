<%-- 
    Document   : bacheca
    Created on : 26-apr-2017, 11.11.10
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/jquery-3.2.1.min.js"></script> 
<script src="js/javascript.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook: Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Davide Fara">
        <meta name="keywords" content="nerdbook Nerd Book social network friends bacheca spam">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidebar1.jsp"/>
                
        <div class="bodyBacheca" id="divBody">
            <jsp:include page="nuovoPost.jsp"/>
            <div class="post">
                <h1>Post:</h1>
            </div>
            <c:set var="title" value="post" scope="request"/>
            
            <c:forEach var="post" items="${posts}">
                <div class="post" <!--id="post1-->">
                    <img id="proPic" title="profilePic" alt="fotoProfilo" src="${post.autore.urlFotoProfilo}">
                    <h3><c:out value="${post.autore.nome} ${post.autore.cognome} ha scritto"/></h3>
                    <c:if test="${post.tipo == 'TEXT'}">
                        <p>${post.contenuto}</p>
                    </c:if>
                    <c:if test="${post.tipo == 'IMAGE'}">
                        <img id="linkedImg" alt="Post con foto" src="${post.urlPost}"/>
                        <p><c:out value="${post.contenuto}"/></p>
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
