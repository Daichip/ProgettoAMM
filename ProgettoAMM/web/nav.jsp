<%-- 
    Document   : nav
    Created on : 24-apr-2017, 12.27.05
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav>
    <ol>
        <li <c:if test="${page == 'descrizione'}">class="active"</c:if>><a href="Descrizione" target="_blank">Il Sito</a></li>
        <li <c:if test="${page == 'login'}">class="active"</c:if>> <a href="Login" target="_blank">Login</a></li>
        <li <c:if test="${page == 'bacheca'}">class="active"</c:if>><a href="Bacheca" target="_blank">Bacheca</a></li>
        <li <c:if test="${page == 'profilo'}">class="active"</c:if>><a href="Profilo" target="_blank">Profilo</a></li>
    </ol>
</nav>