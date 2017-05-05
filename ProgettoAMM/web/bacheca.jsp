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
        <c:set var="title" value="bacheca" scope="request"/>
        <jsp:include page="sidebar1.jsp"/>
        
        <div class="bodyBacheca" id="divBody">
            <div class="post">
                <h1>Post:</h1>
            </div>
            <c:forEach var="post" items="${posts}">
                <div class="post" <!--id="post1-->">
                    <c:if test="${post.TipoPost == 'TEXT'}">
                        <p>${post.contenuto}</p>
                    </c:if>
                    <c:if test="${post.TipoPost == 'IMAGE'}">
                        <img alt="Post con foto" src="${post.contenuto}">
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </body>
</html>