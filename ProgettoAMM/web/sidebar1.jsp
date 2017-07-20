<%-- 
    Document   : sidebar1
    Created on : 24-apr-2017, 12.02.19
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="sideBar" id="side1">
    <div id="cercaUtente">
        <h2>Ricerca</h2>
        <input id="ricerca" type="text" placeholder="Inserisci il nome dell'utente da cercare" value="" onkeyup=trySearch()>
        <button id="bottoneRicercaUtente" >Cerca</button>    
    </div>
    <div>
    <h2>Persone</h2>
    <nav class="sideList" id="sidePersone">
        <ul>
            <c:forEach var="utente" items="${utList}">
                <li><a href="Bacheca?user=${utente.id}"> ${utente.nome} ${utente.cognome} </a></li>
            </c:forEach>
        </ul>
    </nav>
    </div>
    <div>
    <h2>Gruppi</h2>
    <nav class="sideList" id="sideGruppi">
        <ul>
            <c:forEach var="gruppo" items="${listaGruppi}">
                <li><a href="Bacheca?user=${gruppo.id}">${gruppo.nomeGruppo}</a></li>
            </c:forEach>
        </ul>
    </nav>
    </div>
        <div id="amicizia">
        <h2>Amicizia</h2>
        <c:if test="${testAmico == 'true'}">
            <p>Amico di ${nomeAmico}</p>
        </c:if>
        <c:if test="${testAmico == 'false'}">
            <form id="formAmicizia" action="Bacheca?user=${utente.id}&chiediAmicizia=true" method="post">
                <button type="submit">Chiedi Amicizia</button>
            </form>
        </c:if>            
    </div>
</div>
