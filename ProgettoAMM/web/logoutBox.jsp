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
        <c:if test="${currentUserPic != null}">
            <img class="iconPic" title="fotoProfiloLogOut" alt="fotoProfiloLogOut" src="${currentUserPic}">
        </c:if>
    </div>
    <div id="nameLogOut">
        <c:if test="${loggedIn == true}">
            <h3><c:out value="${currentUserInfo}"/></h3>
            <p><a href="Login?logout=true">Logout</a></p>
        </c:if>
        <c:if test="${loggedIn != true}">
            <p><a href="Login">Login</a></p>
        </c:if>
    </div>
</div>
